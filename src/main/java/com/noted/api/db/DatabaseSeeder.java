package com.noted.api.db;

import com.noted.api.model.Note;
import com.noted.api.model.Notebook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private NotebooksRepository _notebooksRepository;
    private NotesRepository _notesRepository;

    public DatabaseSeeder(NotesRepository notesRepository, NotebooksRepository notebooksRepository) {
        this._notesRepository = notesRepository;
        this._notebooksRepository = notebooksRepository;
    }

    @Override
    public void run(String... args) {
        // Remove all existing entities
        this._notebooksRepository.deleteAll();
        this._notesRepository.deleteAll();

        // Save a default notebook
        var defaultNotebook = new Notebook("Default");
        this._notebooksRepository.save(defaultNotebook);

        var quotesNotebook = new Notebook("Quotes");
        this._notebooksRepository.save(quotesNotebook);

        // Save the welcome note
        var note1 = new Note("Hello 1", "Welcome to Note It", defaultNotebook);
        var note2 = new Note("Hello 2", "Welcome to Note It", defaultNotebook);
        this._notesRepository.save(note1);
        this._notesRepository.save(note2);

        System.out.println("Initialized database");
    }
}
