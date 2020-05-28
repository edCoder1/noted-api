package noted.services;

import noted.db.NotesRepository;
import noted.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NoteService {

    private NotesRepository _noteRepository;

    public NoteService(NotesRepository noteRepository) {
        this._noteRepository = noteRepository;
    }

    public UUID createNote(String title, String text) throws Throwable{
        try{
            Note createdNote = new Note(title, text);

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

    public List<Note> getAllNotes() {
        return this._noteRepository.findAll();
    }

    public Note getOneByID(String id) {
        boolean present = this._noteRepository.findById(UUID.fromString(id)).isPresent();
        if (!present) {
            return null;
        }

        return this._noteRepository.findById(UUID.fromString(id)).get();
    }
}
