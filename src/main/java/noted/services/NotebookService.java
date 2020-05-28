package noted.services;

import noted.api.DTO.NotebookDTO;
import noted.model.Notebook;
import org.springframework.stereotype.Component;

@Component
public class NotebookService {

    public Notebook createNotebook(String name) {
        Notebook notebook = new Notebook(name);

        System.out.println(notebook.getId());
        System.out.println(notebook.getName());
        System.out.println(notebook.getNotes().toString());

        return notebook;
    }
}
