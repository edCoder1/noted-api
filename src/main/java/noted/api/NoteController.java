package noted.api;

import noted.api.DTO.NoteDTO;
import noted.model.Note;
import noted.services.NoteService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController()
@RequestMapping(value = "/api")
public class NoteController {

    private NoteService _notesService;

    public NoteController(NoteService notesService) {
        this._notesService = notesService;
    }

    @RequestMapping(value = "/note/all", method = RequestMethod.GET)
    public List<Note> getAll() {
        return this._notesService.getAllNotes();
    }

    @RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
    public Note getOneById(@PathVariable String id) throws EntityNotFoundException {
        return this._notesService.getOneByID(id);
    }

    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public UUID createNote(@RequestBody NoteDTO newNote) throws Throwable {
        try {
            return this._notesService.createNote(newNote.title, newNote.text, newNote.notebook_id);
        } catch (Throwable ex) {
            throw new Throwable(ex);
        }
    }

}
