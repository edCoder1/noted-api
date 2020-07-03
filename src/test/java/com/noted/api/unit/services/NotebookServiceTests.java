package com.noted.api.unit.services;

import com.noted.api.interfaces.INotebookService;
import com.noted.api.model.Notebook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class NotebookService_STUB implements INotebookService {

    @Override
    public List<Notebook> getAll() {
        final List<Notebook> expected = new ArrayList<Notebook>();
        expected.add(new Notebook("STUBBED NOTEBOOK!!!"));
        return expected;
    }

    @Override
    public Notebook getById(final String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Notebook addNotes(final String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Notebook createNotebook(final String name) {
        // TODO Auto-generated method stub
        return null;
    }

}

public class NotebookServiceTests {

    // @InjectMocks
    // NotebooksRepository _notebooksRepository;

    // @Mock
    // NotebooksRepository get_notebooksRepository;

    @Test
    public void getAllNotebooks_BASIC() {
        final INotebookService _notebookService = new NotebookService_STUB();

        final List<Notebook> allNotebooks = _notebookService.getAll();

        final List<Notebook> expected = new ArrayList<>();
        expected.add(new Notebook("STUBBED NOTEBOOK!!!"));

        assertEquals(expected.toArray().length, allNotebooks.toArray().length);
    }

}
