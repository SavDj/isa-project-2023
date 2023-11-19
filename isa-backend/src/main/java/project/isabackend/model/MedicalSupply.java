package project.isabackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MedicalSupplies")
public class MedicalSupply {
    @Id
    @SequenceGenerator(name = "medicalSupplyIdGenerator", sequenceName = "medicalSupplyIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicalSupplyIdGenerator")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private int name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MedicalSupplyType type;

    @Column(name = "description")
    private String description;

    @Column(name = "avgRating")
    private double avgRating;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name = "supplying", joinColumns = @JoinColumn(name = "supply_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"))
    private Set<Company> companies = new HashSet<>();

    @Column(name = "stock")
    private int stock;

    public MedicalSupply() {
    }

    public MedicalSupply(long id, int name, MedicalSupplyType type, String description, double avgRating, Set<Company> companies, int stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.avgRating = avgRating;
        this.companies = companies;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public MedicalSupplyType getType() {
        return type;
    }

    public void setType(MedicalSupplyType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
