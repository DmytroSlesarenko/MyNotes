package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mynotes.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
