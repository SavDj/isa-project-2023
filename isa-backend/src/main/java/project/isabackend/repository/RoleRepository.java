package project.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.isabackend.model.Role;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
