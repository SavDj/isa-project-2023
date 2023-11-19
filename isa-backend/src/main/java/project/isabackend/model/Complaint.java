package project.isabackend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Complaints")
public class Complaint {
    @Id
    @SequenceGenerator(name = "complaintIdGenerator", sequenceName = "complaintIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaintIdGenerator")
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Company company;

    @ManyToOne
    private CompanyAdministrator administrator;

    @ManyToOne
    private RegisteredUser user;

    @Column(name = "description")
    private String description;

    public Complaint() {
    }

    public Complaint(long id, Company company, CompanyAdministrator administrator, RegisteredUser user, String description) {
        this.id = id;
        this.company = company;
        this.administrator = administrator;
        this.user = user;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyAdministrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(CompanyAdministrator administrator) {
        this.administrator = administrator;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
