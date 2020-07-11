package com.noted.api.controllers.DTO;

import javax.validation.constraints.NotNull;

public class NoteDTO {
    @NotNull(message = "A Note must contain a Title")
    public String title;
    public String text;
    @NotNull(message = "A Note must be created with an ID")
    public String notebook_id;
}

