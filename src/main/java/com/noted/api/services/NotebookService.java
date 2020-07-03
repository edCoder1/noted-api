package com.noted.api.services;

import com.noted.api.db.NotebooksRepository;
import com.noted.api.interfaces.INotebookService;
import com.noted.api.model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
// import java.util.Optional;
import java.util.UUID;

@Component
public class NotebookService implements INotebookService {

    @Autowired
    private NotebooksRepository _notebooksRepository; // This replaces below commented code.. or is it vice versa?

    // private final NotebooksRepository _notesRepository;

    // public NotebookService(NotebooksRepository notebooksRepository) {
    // this._notesRepository = notebooksRepository;
    // }

    public List<Notebook> getAll() {
        return this._notebooksRepository.findAll();
    }

    public Notebook getById(final String id) {
        return this._notebooksRepository.findById(UUID.fromString(id)).get();
    }

    public Notebook addNotes(final String id) {
        if (!this._notebooksRepository.existsById(UUID.fromString(id))) {
            return null;
        }

        return this._notebooksRepository.findById(UUID.fromString(id)).get();
    }

    public Notebook createNotebook(final String name) {
        final Notebook notebook = new Notebook(name);

        System.out.println(notebook.getId());
        System.out.println(notebook.getName());
        System.out.println(notebook.getNotes());

        this._notebooksRepository.save(notebook);

        return notebook;
    }

    public Notebook updateNotebook(Notebook notebook) {
        Notebook notebooktoUpdate = this._notebooksRepository.save(notebook);
        return notebooktoUpdate;
    }

    public void deleteNotebook(String id) {
        this._notebooksRepository.deleteById(UUID.fromString(id));
    }
}
