package project.isabackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RegisteredUsers")
public class RegisteredUser extends User{
    @Column(name = "points")
    private int points;
    @Column(name = "penalties")
    private int penalties;
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private UserCategory category;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "hospital_information", nullable = false)
    private String hospitalInformation;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new HashSet<Complaint>();

    public RegisteredUser() {
    }

    public RegisteredUser(int points, int penalties, UserCategory category, String country, String city, String occupation, String hospitalInformation) {
        this.points = points;
        this.penalties = penalties;
        this.category = category;
        this.country = country;
        this.city = city;
        this.occupation = occupation;
        this.hospitalInformation = hospitalInformation;
    }

    public RegisteredUser(long id, String email, String password, String firstName, String lastName, String phoneNumber, Set<Role> roles, int points, int penalties, UserCategory category, String country, String city, String occupation, String hospitalInformation) {
        super(id, email, password, firstName, lastName, phoneNumber, roles);
        this.points = points;
        this.penalties = penalties;
        this.category = category;
        this.country = country;
        this.city = city;
        this.occupation = occupation;
        this.hospitalInformation = hospitalInformation;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public UserCategory getCategory() {
        return category;
    }

    public void setCategory(UserCategory category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHospitalInformation() {
        return hospitalInformation;
    }

    public void setHospitalInformation(String hospitalInformation) {
        this.hospitalInformation = hospitalInformation;
    }
}
