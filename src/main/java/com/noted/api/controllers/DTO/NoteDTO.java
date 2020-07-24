package com.noted.api.controllers.DTO;

import com.noted.api.model.Notebook;

import javax.validation.constraints.NotNull;

public class NoteDTO {
    @NotNull(message = "A Note must contain a Title")
    public String title;
    @NotNull(message = "A Note must contain a Title")
    public String text;
    @NotNull(message = "A Note must be attached to a Notebook")
    public Notebook notebook;
}

