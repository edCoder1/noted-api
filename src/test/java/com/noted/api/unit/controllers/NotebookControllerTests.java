package com.noted.api.unit.controllers;

import com.noted.api.api.NotebookController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@WebMvcTest(NotebookController.class)
public class NotebookControllerTests {
    @Test
    public void contextLoaded() {

    }

    @Test
    public void getAllNotebooks_BASIC() {

    }
}
