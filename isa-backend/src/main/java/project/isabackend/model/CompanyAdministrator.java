package project.isabackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CompanyAdministrators")
public class CompanyAdministrator extends User{
    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();

    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new HashSet<Complaint>();

    public CompanyAdministrator() {
    }

    public CompanyAdministrator(long id, String email, String password, String firstName, String lastName, String phoneNumber, Set<Role> roles, Company company, Set<Appointment> appointments, Set<Complaint> complaints) {
        super(id, email, password, firstName, lastName, phoneNumber, roles);
        this.company = company;
        this.appointments = appointments;
        this.complaints = complaints;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }
}
