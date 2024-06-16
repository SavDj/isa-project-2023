package project.isabackend.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SystemAdministrators")
public class SystemAdministrator extends User{
    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ComplaintResponse> complaintResponses = new HashSet<ComplaintResponse>();

    public SystemAdministrator() {
    }

    public SystemAdministrator(long id, String email, String password, String firstName, String lastName, String phoneNumber, Role role, Set<ComplaintResponse> complaintResponses) {
        super(id, email, password, firstName, lastName, phoneNumber, role);
        this.complaintResponses = complaintResponses;
    }

    public Set<ComplaintResponse> getComplaintResponses() {
        return complaintResponses;
    }

    public void setComplaintResponses(Set<ComplaintResponse> complaintResponses) {
        this.complaintResponses = complaintResponses;
    }
}
