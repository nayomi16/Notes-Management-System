package lk.company.notesmanagementAPI.service.impl;

import lk.company.notesmanagementAPI.dto.NoteArchiveDto;
import lk.company.notesmanagementAPI.dto.NoteDto;
import lk.company.notesmanagementAPI.entity.Note;
import lk.company.notesmanagementAPI.entity.NoteArchive;
import lk.company.notesmanagementAPI.entity.User;
import lk.company.notesmanagementAPI.repository.NoteArchiveRepository;
import lk.company.notesmanagementAPI.repository.NoteRepository;
import lk.company.notesmanagementAPI.repository.UserRepository;
import lk.company.notesmanagementAPI.service.NoteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoteArchiveRepository noteArchiveRepository;

    @Override
    public void save(NoteDto noteDto) {
        if (noteRepository.existsById(noteDto.getNoteId())) {
            throw new RuntimeException("Note Already Exist");
        }
        Date currentDate = new Date();
        User user = userRepository.findById(noteDto.getUserId()).get();
        Note note = new Note(noteDto.getNoteId(), noteDto.getDescription(), user, currentDate);
        noteRepository.save(note);
    }

    @Override
    public void updateNote(NoteDto noteDto) {
        if (!noteRepository.existsById(noteDto.getNoteId())) {
            throw new RuntimeException("No such note to update");
        }
        Date currentDate = new Date();
        User user = userRepository.findById(noteDto.getUserId()).get();
        Note note = new Note(noteDto.getNoteId(), noteDto.getDescription(), user, currentDate);
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(String id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else if (noteArchiveRepository.existsById(id)) {
            noteArchiveRepository.deleteById(id);
        } else
            throw new RuntimeException("Such note doesn't exist");
    }

    @Override
    public void archiveNote(String id) {
        if (!noteRepository.existsById(id)) {
            throw new RuntimeException("Such note doesn't exist");
        }
        Note note = noteRepository.findById(id).get();
        noteRepository.deleteById(id);
        NoteArchive archive = new NoteArchive(note.getNoteId(), note.getDescription(), note.getUser(), new Date());
        noteArchiveRepository.save(archive);

    }

    @Override
    public void unArchiveNote(String notId) {
        if (!noteArchiveRepository.existsById(notId)) {
            throw new RuntimeException("Such note doesn't exist");
        }
        NoteArchive noteArchive = noteArchiveRepository.findById(notId).get();
        noteArchiveRepository.deleteById(notId);
        Note note = new Note(noteArchive.getNoteId(), noteArchive.getDescription(), noteArchive.getUser(), new Date());
        noteRepository.save(note);

    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> all = noteRepository.findAll();
        return modelMapper.map(all, new TypeToken<List<NoteDto>>() {
        }.getType());
    }

    @Override
    public List<NoteArchiveDto> getAllArchivedNotes() {
        List<NoteArchive> all = noteArchiveRepository.findAll();
        return modelMapper.map(all, new TypeToken<List<NoteArchiveDto>>() {
        }.getType());
    }
}

