package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.mynotes.models.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "SELECT * FROM notes WHERE folder_id = ?1", nativeQuery = true)
    List<Note> findAllByFolderId(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE notes SET folder_id = null WHERE folder_id = ?1", nativeQuery = true)
    void deleteFolderId(Long id);
}
