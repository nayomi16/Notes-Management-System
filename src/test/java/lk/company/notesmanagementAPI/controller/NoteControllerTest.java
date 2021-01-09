package lk.company.notesmanagementAPI.controller;

import lk.company.notesmanagementAPI.dto.NoteDto;
import lk.company.notesmanagementAPI.entity.Note;
import lk.company.notesmanagementAPI.entity.NoteArchive;
import lk.company.notesmanagementAPI.response.StandardResponse;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NoteControllerTest {

    @MockBean
    NotesController notesController;


    @Test
    public void saveNoteTest(){
        NoteDto noteDto=Mockito.mock(NoteDto.class);
        notesController.saveNote(new NoteDto("N001","jjjjj","U001"));
    }

    @Test
    public void getAllNotesTest(){
        List<Note> list=new ArrayList<>();
        ResponseEntity responseEntity=new ResponseEntity(new StandardResponse(200, "true", list), HttpStatus.OK);
        Mockito.when(notesController.getAllNotes()).thenReturn(responseEntity);

    }

    @Test
    public void getAllArchivedNotesTest(){
        List<NoteArchive> list=new ArrayList<>();
        ResponseEntity responseEntity=new ResponseEntity(new StandardResponse(200, "true", list), HttpStatus.OK);
        Mockito.when(notesController.getAllArchivedNotes()).thenReturn(responseEntity);
    }

    @Test
    public void updateNoteTest(){
//        NoteDto noteDto=Mockito.mock(NoteDto.class);
        notesController.updateNote(new NoteDto("N001","jjjjj","U001"));
    }

    @Test
    public void deleteNoteTest(){
        String notId="nayomi";
        notesController.deleteNote(notId);
    }

    @Test
    public void archiveNoteTest(){
        String notId="hh";
        notesController.archiveNote(notId);
    }

    @Test
    public void unArchiveNoteTest(){
        String notId="hh";
        notesController.unArchiveNote(notId);
    }



}
