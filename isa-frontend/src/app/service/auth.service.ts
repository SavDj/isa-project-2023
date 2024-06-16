import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { User } from '../model/user.model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../env/environment';
import { Login } from '../model/login.model';
import { Registration } from '../model/registration.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user$ = new BehaviorSubject<User>({username: "", role: "" });

  constructor(private http: HttpClient,
    private router: Router) { }

  login(login: Login): Observable<any> {
    return this.http
      .post<any>(environment.apiHost + 'auth/login', login)
      .pipe(
        tap(() => {
          this.setUser();
        })
      );
  }

  register(registration: Registration): Observable<any> {
    return this.http
    .post<any>(environment.apiHost + 'auth/register', registration);
  }

  logout(): void {
    this.http.post(environment.apiHost + 'auth/logout', {}).subscribe({
      next: () => {
        this.user$.next({ username: "", role: "" });
        this.router.navigate(['/home']);
      },
      error: (error) => {
        console.error('Error during logout:', error);
      }
    });
  }

  private setUser(): void {
    this.http.get<User>(environment.apiHost + 'auth/user-info').subscribe({
      next: (result: any) => {
        const user: User = {
          username: result.email,
          role: result.role
        };
        this.user$.next(user);
      },
      error: (error) => {
        console.error('Error fetching user info:', error);
      }})
  }

}
