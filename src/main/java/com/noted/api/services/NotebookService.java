package com.noted.api.services;

import com.noted.api.db.NotebooksRepository;
import com.noted.api.interfaces.INotebookService;
import com.noted.api.model.Notebook;
import com.noted.api.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
        this._notebooksRepository.save(notebook);

        return notebook;
    }

    public Notebook updateNotebook(Notebook notebook) {

         this._notebooksRepository.save(notebook);

        // better ?
//        Notebook notebookToUpdate = this._notebooksRepository.findById(notebook.getId()).orElse(null);
//
//        if (notebook != null) {
//            notebook.setName(notebook.getName());
//            this._notebooksRepository.save(notebook);
//            System.out.println(notebook.getName());
//        }

        return notebook;
    }

    public Notebook deleteNotebook(String id) {
        Notebook notebook = this._notebooksRepository.findById(UUID.fromString(id)).orElse(null);

        if (notebook != null) {
            this._notebooksRepository.deleteById(UUID.fromString(id));
        }

        return notebook;
    }

    public List<Note> getNotesOfNotebook(String id) {
        final List<Note> notes = this._notebooksRepository.findById(UUID.fromString(id)).orElse(null).getNotes();
//         may fail ???
        return notes;

    }
}
