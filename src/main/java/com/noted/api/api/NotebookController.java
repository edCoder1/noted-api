package com.noted.api.api;

import com.noted.api.api.DTO.NotebookDTO;
import com.noted.api.model.Notebook;
import com.noted.api.services.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NotebookController {

    @Autowired
    private NotebookService _notebookService;   // This replaces below commented code.. or is it vice versa?

//    private NotebookService _notebookService;
//
//    public NotebookController(NotebookService notebookService) {
//        this._notebookService = notebookService;
//    }

    @RequestMapping(value = "/notebook/all", method = RequestMethod.GET)
    public List<Notebook> getAllNotebooks(){
        return this._notebookService.getAll();
    }

    @RequestMapping(value = "/notebook/{id}", method = RequestMethod.GET)
    public Notebook getOneById(@PathVariable String id) {
        return this._notebookService.getById(id);
    }


    @RequestMapping(value = "/notebook", method = RequestMethod.POST)
    public Notebook createNotebook(@RequestBody NotebookDTO notebook) {
        return this._notebookService.createNotebook(notebook.name);
    }

    @RequestMapping(value = "/notebook/addNotes/{id}", method = RequestMethod.POST)
    public Notebook addNotes(@PathVariable String id){
        return this._notebookService.addNotes(id);
    }
}
