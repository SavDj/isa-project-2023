package project.isabackend.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @SequenceGenerator(name = "roleIdGenerator", sequenceName = "roleIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleIdGenerator")
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public Role() {
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
}

