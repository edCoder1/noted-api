package noted.services;

import noted.db.NotesRepository;
import noted.model.Note;
import noted.model.Notebook;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Component
public class NoteService {

    private NotesRepository _noteRepository;

    public NoteService(NotesRepository noteRepository) {
        this._noteRepository = noteRepository;
    }

    public UUID createNote(String title, String text, String notebookId) throws Throwable{
        try{
            // Add note to notebook
            Note createdNote = new Note(title, text, notebookId);


            System.out.println(createdNote);
            System.out.println(createdNote.getId());
            System.out.println(createdNote.getTitle());
            System.out.println(createdNote.getText());

            this._noteRepository.save(createdNote);

            return createdNote.getId();
        } catch (Throwable ex) {
            throw new Throwable(ex);
        }
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
}
