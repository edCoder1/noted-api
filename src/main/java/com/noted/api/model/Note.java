package com.noted.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
public class Note {

    @Id
    @NotNull(message = "A Note must be created with an ID")
    private UUID id;
    @NotNull(message = "A Note must contain a title")
    private String title;
    private String text;

    // private String notebookId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notebook notebook;

    private Date lastModifiedOn;

    // Required for @Entity
    public Note() {
    }

    public Note(String title, String text, String notebookId) {
        this.title = title;
        this.text = text;
        this.id = UUID.randomUUID();
        this.lastModifiedOn = new Date();
        // this.notebookId = notebookId;

        // this.notebook.

        // System.out.println(this.notebook.getNotes().toString());
    }

    public Note(String title, String text, Notebook notebook) {
        this.title = title;
        this.text = text;
        this.id = UUID.randomUUID();
        this.lastModifiedOn = new Date();
        // this.notebookId = notebookId;

        this.notebook = notebook;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    // public String getNotebookId() {
    // return this.notebookId;
    // }

}
