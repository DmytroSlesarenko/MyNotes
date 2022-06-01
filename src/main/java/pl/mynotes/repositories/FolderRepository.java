package pl.mynotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mynotes.models.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {


}
