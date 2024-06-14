package project.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.isabackend.model.RegisteredUser;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findByEmail(String email);
}
