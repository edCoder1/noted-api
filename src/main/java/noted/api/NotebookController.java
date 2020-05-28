package noted.api;

import noted.api.DTO.NotebookDTO;
import noted.model.Notebook;
import noted.services.NotebookService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class NotebookController {

    private NotebookService _notebookService;

    public NotebookController(NotebookService notebookService) {
        this._notebookService = notebookService;
    }

    @RequestMapping(value = "/notebook", method = RequestMethod.POST)
    public String createNotebook(@RequestBody NotebookDTO notebook) {
        Notebook newNotebook = this._notebookService.createNotebook(notebook.name);
        return newNotebook.getName();
    }

}
