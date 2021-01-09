package lk.company.notesmanagementAPI.service;

import lk.company.notesmanagementAPI.dto.NoteDto;
import lk.company.notesmanagementAPI.entity.Note;
import lk.company.notesmanagementAPI.entity.NoteArchive;
import lk.company.notesmanagementAPI.entity.User;
import lk.company.notesmanagementAPI.repository.NoteArchiveRepository;
import lk.company.notesmanagementAPI.repository.NoteRepository;
import lk.company.notesmanagementAPI.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class NoteServiceTest {

    @MockBean
    NoteService noteService;

    @MockBean
    NoteRepository noteRepository;
    @MockBean
    ModelMapper modelMapper;
    @MockBean
    UserRepository userRepository;
    @MockBean
    NoteArchiveRepository noteArchiveRepository;

    @Test
    public void saveTest() {
        User user=new User();
        NoteDto noteDto=new NoteDto("test","test","testuserID");
//        Mockito.when(userRepository.findById(noteDto.getUserId()).get()).thenReturn(user);
        Note note = new Note("test", "test", user, new Date());
        noteRepository.save(note);

    }

    @Test
    public void deleteNoteTest() {
        Mockito.when(noteRepository.existsById("testid")).thenReturn(true);
        Mockito.when(noteArchiveRepository.existsById("testid")).thenReturn(false);
        noteRepository.deleteById("testid");

    }

    @Test
    public void updateNoteTest() {
        Note note = new Note("testid", "test description", new User(), new Date());
        noteRepository.save(note);

    }

    @Test
    public void archiveNoteTest() {
//        Mockito.when(noteRepository.findById("test").get()).thenReturn(new Note());
        noteRepository.deleteById("test");
        NoteArchive archive = new NoteArchive("test", "test des", new User(), new Date());
        noteArchiveRepository.save(archive);

    }

    @Test
    public void unArchiveNote(){
        noteArchiveRepository.deleteById("test id");
        Note note = new Note("test", "test des", new User(), new Date());
        noteRepository.save(note);
    }

    @Test
    public void getAllNotes(){
        List<Note> all = new ArrayList<>();
        Mockito.when(noteRepository.findAll()).thenReturn(all);

    }

    @Test
    public void getAllArchivedNotes(){
        List<NoteArchive> all = new ArrayList<>();
        Mockito.when(noteArchiveRepository.findAll()).thenReturn(all);
    }

}
