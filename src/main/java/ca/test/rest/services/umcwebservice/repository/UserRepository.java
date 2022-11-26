package ca.test.rest.services.umcwebservice.repository;

import ca.test.rest.services.umcwebservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
