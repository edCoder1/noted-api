package com.noted.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Notebook {

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Note[] getNotes() {
        return notes;
    }

    @Id
    private UUID id;
    private String name;
    private Note[] notes = {};

    //  Required for @Entity
    public Notebook() {
    }

    public Notebook(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

}
