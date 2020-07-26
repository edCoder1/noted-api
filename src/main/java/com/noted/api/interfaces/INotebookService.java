package com.noted.api.interfaces;

import com.noted.api.model.Notebook;

import java.util.List;

public interface INotebookService {
    List<Notebook> getAll();

    Notebook getById(String id);

    Notebook createNotebook(String name);
}
