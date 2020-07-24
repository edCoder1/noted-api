package com.noted.api.db;

import com.noted.api.model.Note;
import com.noted.api.model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * This component will only execute (and get initialized) if the property
 * noted.db.recreate is set tp true in application.properties file
 */

@Component
@ConditionalOnProperty(name = "noted.db.recreate", havingValue = "true")
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private NotebooksRepository _notebooksRepository;
    @Autowired
    private NotesRepository _notesRepository;

//    public DatabaseSeeder(NotesRepository notesRepository, NotebooksRepository notebooksRepository) {
//        this._notesRepository = notesRepository;
//        this._notebooksRepository = notebooksRepository;
//    }

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
