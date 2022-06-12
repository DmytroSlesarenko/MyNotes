package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mynotes.models.Friends;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
}
