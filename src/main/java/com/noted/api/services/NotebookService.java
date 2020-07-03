package com.noted.api.services;

import com.noted.api.db.NotebooksRepository;
import com.noted.api.interfaces.INotebookService;
import com.noted.api.model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NotebookService implements INotebookService {

    @Autowired
    private NotebooksRepository _notesRepository;         // This replaces below commented code.. or is it vice versa?

    public NotebookService() {
    }

//    private final NotebooksRepository _notesRepository;

//    public NotebookService(NotebooksRepository notebooksRepository) {
//        this._notesRepository = notebooksRepository;
//    }

    public List<Notebook> getAll(){
        return this._notesRepository.findAll();
    }

    public Notebook getById(String id) {
        return this._notesRepository.findById(UUID.fromString(id)).get();
    }

    public Notebook addNotes(String id){
        if ( !this._notesRepository.existsById(UUID.fromString(id)) ) {
            return null;
        }

        return this._notesRepository.findById(UUID.fromString(id)).get();
    }

    public Notebook createNotebook(String name) {
        Notebook notebook = new Notebook(name);

        System.out.println(notebook.getId());
        System.out.println(notebook.getName());
        System.out.println(notebook.getNotes());

        this._notesRepository.save(notebook);

        return notebook;
    }


}
