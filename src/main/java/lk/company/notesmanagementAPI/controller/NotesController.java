package lk.company.notesmanagementAPI.controller;

import lk.company.notesmanagementAPI.dto.NoteArchiveDto;
import lk.company.notesmanagementAPI.dto.NoteDto;
import lk.company.notesmanagementAPI.response.StandardResponse;
import lk.company.notesmanagementAPI.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    NoteService noteService;


    @PostMapping("/")
    public ResponseEntity saveNote(@RequestBody NoteDto noteDto) {
        noteService.save(noteDto);
        return new ResponseEntity(new StandardResponse(200, "true! saved successfully", null), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllNotes() {
        List<NoteDto> allNotes = noteService.getAllNotes();
        return new ResponseEntity(new StandardResponse(200, "true!", allNotes), HttpStatus.OK);
    }

    @GetMapping(path = "/archivednotes")
    public ResponseEntity<StandardResponse> getAllArchivedNotes() {
        List<NoteArchiveDto> allArchivedNotes = noteService.getAllArchivedNotes();
        return new ResponseEntity(new StandardResponse(200, "true", allArchivedNotes), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity updateNote(@RequestBody NoteDto noteDto) {
        noteService.updateNote(noteDto);
        return new ResponseEntity(new StandardResponse(200, "true! updated successfully", null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"noteId"})
    public ResponseEntity deleteNote(@RequestParam String noteId) {
        noteService.deleteNote(noteId);
        return new ResponseEntity(new StandardResponse(200, "true! deleted successfully", null), HttpStatus.OK);
    }

    @PutMapping(path = "/archive", params = {"noteId"})
    public ResponseEntity archiveNote(@RequestParam String noteId) {
        noteService.archiveNote(noteId);
        return new ResponseEntity(new StandardResponse(200, "true! archived successfully", null), HttpStatus.OK);
    }

    @PutMapping(path = "/unarchive", params = {"noteId"})
    public ResponseEntity unArchiveNote(@RequestParam String noteId) {
        noteService.unArchiveNote(noteId);
        return new ResponseEntity(new StandardResponse(200, "true! unarchived successfully", null), HttpStatus.OK);
    }


}
