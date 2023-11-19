package project.isabackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Companies")
public class Company {
    @Id
    @SequenceGenerator(name = "companyIdGenerator", sequenceName = "companyIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyIdGenerator")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "avg_rating")
    private double avgRating;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> freeAppointments = new HashSet<Appointment>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CompanyAdministrator> companyAdministrators = new HashSet<CompanyAdministrator>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name = "supplying", joinColumns = @JoinColumn(name = "supply_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
    private Set<MedicalSupply> medicalSupplies = new HashSet<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new HashSet<Complaint>();

    public Company() {
    }

    public Company(long id, String name, String address, double avgRating, String description, Set<Appointment> freeAppointments, Set<CompanyAdministrator> companyAdministrators, Set<MedicalSupply> medicalSupplies, Set<Complaint> complaints) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.avgRating = avgRating;
        this.description = description;
        this.freeAppointments = freeAppointments;
        this.companyAdministrators = companyAdministrators;
        this.medicalSupplies = medicalSupplies;
        this.complaints = complaints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Appointment> getFreeAppointments() {
        return freeAppointments;
    }

    public void setFreeAppointments(Set<Appointment> freeAppointments) {
        this.freeAppointments = freeAppointments;
    }

    public Set<CompanyAdministrator> getCompanyAdministrators() {
        return companyAdministrators;
    }

    public void setCompanyAdministrators(Set<CompanyAdministrator> companyAdministrators) {
        this.companyAdministrators = companyAdministrators;
    }

    public Set<MedicalSupply> getMedicalSupplies() {
        return medicalSupplies;
    }

    public void setMedicalSupplies(Set<MedicalSupply> medicalSupplies) {
        this.medicalSupplies = medicalSupplies;
    }

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }
}
