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

//    public Notebook getNotebook() {/**/
//        return notebook;
//    }

//    public void setNotebook(Notebook notebook) {
//        this.notebook = notebook;
//    }

    // public String getNotebookId() {
    // return this.notebookId;
    // }

//    public String getNotebookId() {
//        return this.notebook.getId().toString();
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

}
