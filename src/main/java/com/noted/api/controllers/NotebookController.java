package com.noted.api.controllers;

import com.noted.api.controllers.DTO.NotebookDTO;
import com.noted.api.model.Note;
import com.noted.api.model.Notebook;
import com.noted.api.services.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class NotebookController {

    @Autowired
    private NotebookService _notebookService; // This replaces below commented code.. or is it vice versa?

    // private NotebookService _notebookService;
    //
    // public NotebookController(NotebookService notebookService) {
    // this._notebookService = notebookService;
    // }

    @RequestMapping(value = "/notebook/all", method = RequestMethod.GET)
    public List<Notebook> getAllNotebooks() {
        final List<Notebook> all = this._notebookService.getAll();
        return all;
    }

    @RequestMapping(value = "/notebook/{id}", method = RequestMethod.GET)
    public Notebook getOneById(@PathVariable String id) {
        return this._notebookService.getById(id);
    }

    @RequestMapping(value = "/notebook", method = RequestMethod.POST)
    public Notebook createNotebook(@Valid @RequestBody NotebookDTO notebook) {
        return this._notebookService.createNotebook(notebook.name);
    }

    @RequestMapping(value = "/notebook", method = RequestMethod.PUT)
    public Notebook updateNotebookName(@Valid @RequestBody Notebook notebook) {
        return this._notebookService.updateNotebook(notebook);
    }

    @RequestMapping(value = "/notebook/{id}", method = RequestMethod.DELETE)
    public Notebook deleteNotebook(@PathVariable String id) {
        return this._notebookService.deleteNotebook(id);
    }

    @RequestMapping(value = "/notebook/{id}/notes", method = RequestMethod.GET)
    public List<Note> getNotesOfNotebook(@PathVariable String id) {
        return this._notebookService.getNotesOfNotebook(id);
    }

}
