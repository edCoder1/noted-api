package com.noted.api.unit.data_layer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.UUID;

import com.noted.api.db.NotebooksRepository;
import com.noted.api.model.Notebook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Since Repository DOESN'T HAVE any methos to test... this is useless.. if it was a Real DB like Hibernate will require some test perhaps

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NotebookRepositoryTests {

    @Autowired
    private NotebooksRepository repository;

    @Test
    public void testFindAll_BASIC() {
        List<Notebook> allNotebooks = repository.findAll();

        assertEquals(4, allNotebooks.size());
    }

    @Test
    public void testGetByID_BASIC() {
        final String uuid = "740557a5-d67f-4a59-8054-3222e9753c9f";

        Notebook notebook = this.repository.findById(UUID.fromString(uuid)).orElse(new Notebook("USELESS TEST?"));

        assertEquals("USELESS TEST?", notebook.getName());
    }

}