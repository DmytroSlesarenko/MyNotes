package pl.mynotes.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.mynotes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
