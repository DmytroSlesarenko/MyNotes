package pl.mynotes.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.mynotes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users_notes(user_id, notes_id) VALUES (?1, ?2)", nativeQuery = true)
    void shareNotes(Long userId, Long noteId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users_notes WHERE notes_id = ?1", nativeQuery = true)
    void shareNotesDelete(Long id);
}
