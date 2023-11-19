package project.isabackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ComplaintResponses")
public class ComplaintResponse {
    @Id
    @SequenceGenerator(name = "complaintResponseIdGenerator", sequenceName = "complaintResponseIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaintResponseIdGenerator")
    @Column(name = "id")
    private long id;

    @OneToOne
    private Complaint complaint;

    @ManyToOne
    private SystemAdministrator administrator;

    @Column(name = "description")
    private String description;
}
