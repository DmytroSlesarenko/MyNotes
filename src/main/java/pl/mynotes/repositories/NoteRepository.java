package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mynotes.models.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
