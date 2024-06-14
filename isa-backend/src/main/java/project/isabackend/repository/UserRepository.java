package project.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.isabackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
