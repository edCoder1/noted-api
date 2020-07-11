package com.noted.api.controllers.DTO;

import javax.validation.constraints.NotNull;

public class NotebookDTO {
    @NotNull(message = "A Notebook must contain a name")
    public String name;
    public String id;
}
