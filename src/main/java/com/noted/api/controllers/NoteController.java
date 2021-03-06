package com.noted.api.controllers;

import com.noted.api.controllers.DTO.NoteDTO;
import com.noted.api.model.Note;
import com.noted.api.services.NoteService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @RequestMapping(value = "/note", method = RequestMethod.PUT)
    public void updateNote(@Valid @RequestBody Note note){
        this._notesService.updateNote(note);
    }

    @RequestMapping(value = "/note/{id}", method = RequestMethod.DELETE)
    public Note deleteNotebook(@PathVariable String id) {
        return this._notesService.deleteNote(id);
    }

    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public Note createNote(@Valid @RequestBody NoteDTO newNote) throws Throwable {
        return this._notesService.createNote(newNote.title, newNote.text, newNote.notebook);
    }

}
