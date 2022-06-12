package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.mynotes.models.Folder;
import pl.mynotes.models.Note;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    @Query(value = "SELECT * FROM folders WHERE user_id = ?1", nativeQuery = true)
    List<Folder> findAllByUserId(Long id);

    @Query(value = "SELECT * FROM folders WHERE name = ?1", nativeQuery = true)
    Folder findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM folders WHERE user_id = ?1", nativeQuery = true)
    void deleteFolderByUserId(Long id);
}
