package noted.api;

import noted.api.DTO.NotebookDTO;
import noted.model.Notebook;
import noted.services.NotebookService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class NotebookController {

    private NotebookService _notebookService;

    public NotebookController(NotebookService notebookService) {
        this._notebookService = notebookService;
    }

    @RequestMapping(value = "/notebook/all", method = RequestMethod.GET)
    public List<Notebook> getAllNotebooks() {
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
    public Notebook addNotes(@PathVariable String id) {
        return this._notebookService.addNotes(id);
    }

    @RequestMapping(value = "/notebook", method = RequestMethod.PUT)
    public Notebook updateNotebookName(@RequestBody Notebook notebook) {
        return this._notebookService.updateNotebook(notebook);
    }

    @RequestMapping(value = "/notebook/{id}", method = RequestMethod.DELETE)
    public void deleteNotebook(@PathVariable String id) {
        this._notebookService.deleteNotebook(id);
    }

}
