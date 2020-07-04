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
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotebookServiceTests {

    @InjectMocks
    private NotebookService service;

    @Mock
    private NotebooksRepository repository;

    @Test
    public void getAllNotebooks_BASIC() {

        when(repository.findAll()).thenReturn(
                Arrays.asList(new Notebook("MOCKED NOTEBOOK!!! 01"), new Notebook("MOCKED NOTEBOOK!!! 02")));

        final List<Notebook> actual = this.service.getAll();

        assertEquals("MOCKED NOTEBOOK!!! 02", actual.get(1).getName());
    }

}
