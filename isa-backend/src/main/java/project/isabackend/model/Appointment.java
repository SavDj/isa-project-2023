package project.isabackend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @SequenceGenerator(name = "appointmentIdGenerator", sequenceName = "appointmentIdsSequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentIdGenerator")
    @Column(name = "id")
    private long id;

    @ManyToOne
    private CompanyAdministrator administrator;

    @ManyToOne
    private Company company;

    @Column
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Column
    @Temporal(TemporalType.TIME)
    private Date appointmentTime;

    @Column(name = "length")
    private int length;

}
