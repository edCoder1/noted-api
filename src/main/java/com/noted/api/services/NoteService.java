package com.noted.api.services;

import com.noted.api.controllers.DTO.NoteDTO;
import com.noted.api.model.Note;
import com.noted.api.model.Notebook;
import com.noted.api.db.NotesRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class NoteService {

    private NotesRepository _noteRepository;

    public NoteService(NotesRepository noteRepository) {
        this._noteRepository = noteRepository;
    }

    public Note createNote(String title, String text, Notebook selectedNotebook) throws Throwable {
            // Add note to notebook
            Note createdNote = new Note(title, text, selectedNotebook);
            this._noteRepository.save(createdNote);
            return createdNote;
    }

    public void addNoteToNotebook(Note note, Notebook notebook){

    }

    public List<Note> getAllNotes() {
        return this._noteRepository.findAll();
    }

    public Note getOneByID(String id) {
        boolean present = this._noteRepository.findById(UUID.fromString(id)).isPresent();
        if (!present) {
            throw new EntityNotFoundException("Did not find any note with id " + id);
        }

        return this._noteRepository.findById(UUID.fromString(id)).get();
    }

    public Note deleteNote(String id) {

        Note note = this._noteRepository.findById(UUID.fromString(id)).orElse(null);

        if (note != null) {
            this._noteRepository.deleteById(UUID.fromString(id));
        }

        return note;
    }

    public void updateNote(Note note) {
        //        ??? IS THIS GOOD

        final Note noteToUpdate = this._noteRepository.findById(UUID.fromString(note.getId().toString())).orElse(null);

        if (noteToUpdate != null) {
            noteToUpdate.setTitle(note.getTitle());
            noteToUpdate.setText(note.getText());
            noteToUpdate.setLastModifiedOn(new Date());

            this._noteRepository.save(noteToUpdate);
        }

    }
}
