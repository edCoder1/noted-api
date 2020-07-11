package com.noted.api.controllers;

import com.noted.api.controllers.DTO.NotebookDTO;
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


@CrossOrigin
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
        System.out.println(all.get(0).getId());
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

    @RequestMapping(value = "/notebook/addNotes/{id}", method = RequestMethod.POST) // Not complete
    public Notebook addNotes(@PathVariable String id) {
        return this._notebookService.addNotes(id);
    }

    @RequestMapping(value = "/notebook/{id}/{newName}", method = RequestMethod.PUT)
    public Notebook updateNotebookName(@PathVariable String id, @PathVariable String newName) {
        return this._notebookService.updateNotebook((id), newName);
    }

    @RequestMapping(value = "/notebook/{id}", method = RequestMethod.DELETE)
    public Notebook deleteNotebook(@PathVariable String id) {
        return this._notebookService.deleteNotebook(id);
    }

}
