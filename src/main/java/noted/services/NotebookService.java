package noted.services;

// import noted.api.DTO.NotebookDTO;
import noted.db.NotebooksRepository;
import noted.model.Notebook;
import org.springframework.stereotype.Component;

import java.util.List;
// import java.util.Optional;
import java.util.UUID;

@Component
public class NotebookService {

    private final NotebooksRepository _notebooksRepository;

    public NotebookService(final NotebooksRepository notebooksRepository) {
        this._notebooksRepository = notebooksRepository;
    }

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
