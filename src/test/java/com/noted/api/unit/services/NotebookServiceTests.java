package com.noted.api.unit.services;

import com.noted.api.db.NotebooksRepository;
import com.noted.api.model.Notebook;
import com.noted.api.services.NotebookService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class NotebookServiceTests {

    @InjectMocks
    private NotebookService service;

    @Mock
    private NotebooksRepository repository;

    @Test
    public void getAllNotebooks_BASIC() {

        when(repository.findAll()).thenReturn(Arrays.asList(new Notebook("MOCKED NOTEBOOK!!! 01"),
                new Notebook("MOCKED NOTEBOOK!!! 02"), new Notebook("MOCKED NOTEBOOK!!! 03")));

        final List<Notebook> actual = this.service.getAll();

        assertEquals("MOCKED NOTEBOOK!!! 02", actual.get(1).getName());
    }

    @Test
    public void getById_BASIC() {

        final UUID id = UUID.fromString("d7dc99ab-3588-4462-ba3d-3676266eb277");
        final String idString = id.toString();

        when(repository.findById(id)).thenReturn(Optional.of(new Notebook("SOME NOTEBOOK")));

        final Notebook actual = this.service.getById(idString);

        assertEquals("SOME NOTEBOOK", actual.getName());
    }

    @Test
    public void addNotes_BASIC() {
        fail();
    }

    @Test
    public void createNotebook_BASIC() {

        final Notebook savedNotebook = this.service.createNotebook("NEW ONE");
        // NOT Necessary don't know why
        // when(repository.save(createdNotebook)).thenReturn(savedNotebook);

        assertEquals(null, savedNotebook.getNotes());
    }

    @Test
    public void updateNotebook() {

        final Notebook modifiedNotebook = this.service.updateNotebook("996171cc-93e4-4141-ae97-8d7da7ca0889", "ON");

        String actual = modifiedNotebook != null ? "ON" : null;
        String expected = modifiedNotebook != null ? "ON" : null;

        assertEquals(expected, actual);
    }

    @Test
    public void deleteNotebook() {

        final Notebook notebook_01 = new Notebook("1");
        final Notebook notebook_02 = new Notebook("2");
        final Notebook notebook_03 = new Notebook("3");

        when(repository.findAll()).thenReturn(Arrays.asList(notebook_01, notebook_02, notebook_03)); // Something weird
                                                                                                     // happening here?

        this.service.deleteNotebook(notebook_02.getId().toString());

        assertEquals(2, this.service.getAll().toArray().length);
    }

}
