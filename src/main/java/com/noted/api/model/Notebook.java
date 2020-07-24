package com.noted.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Entity
public class Notebook {

    @Id
    @NotNull(message = "A Notebook must be created with an ID")
    private UUID id;
    @NotNull(message = "A Notebook must contain a name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Note> notes;

    // Required for @Entity
    public Notebook() {
    }

    public Notebook(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public String setName(String newName) {
        this.name = newName;
        return newName;
    }

}
