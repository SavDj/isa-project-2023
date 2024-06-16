import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Registration } from '../model/registration.model';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  registrationForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    surname: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    password2: new FormControl('', [Validators.required]),
    city: new FormControl('', [Validators.required]),
    country: new FormControl('', [Validators.required]),
    phoneNumber: new FormControl('', [Validators.required]),
    occupation: new FormControl('', [Validators.required]),
    hospitalInformation: new FormControl('', [Validators.required])
  });

  register(): void {
    const password2 = this.registrationForm.value.password2 || "";

    const registration: Registration = {
      firstName: this.registrationForm.value.name || "",
      lastName: this.registrationForm.value.surname || "",
      email: this.registrationForm.value.email || "",
      password: this.registrationForm.value.password || "",
      city: this.registrationForm.value.city || "",
      country: this.registrationForm.value.country || "",
      phoneNumber: this.registrationForm.value.phoneNumber || "",
      occupation: this.registrationForm.value.occupation || "",
      hospitalInformation: this.registrationForm.value.hospitalInformation || ""
    };

    if (this.registrationForm.valid && registration.password === password2) {
      this.authService.register(registration).subscribe({
        next: () => {
          this.router.navigate(['home']);
        },
      });
    } else {
      this.registrationForm.controls['password2'].setErrors({ mismatch: true });
    }
  }
}
