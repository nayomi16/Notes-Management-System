package lk.company.notesmanagementAPI.repository;

import lk.company.notesmanagementAPI.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,String> {


}
