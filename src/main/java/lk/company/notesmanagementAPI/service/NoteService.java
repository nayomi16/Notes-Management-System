package lk.company.notesmanagementAPI.service;

import lk.company.notesmanagementAPI.dto.NoteArchiveDto;
import lk.company.notesmanagementAPI.dto.NoteDto;

import java.util.List;


public interface NoteService {


    void save(NoteDto noteDto);

    void updateNote(NoteDto noteDto);

    void deleteNote(String id);

    void archiveNote(String id);

    void unArchiveNote(String notId);

    List<NoteDto> getAllNotes();

    List<NoteArchiveDto> getAllArchivedNotes();
}
