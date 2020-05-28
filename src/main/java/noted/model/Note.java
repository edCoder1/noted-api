package noted.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Entity
public class Note {

    @Id
    private UUID id;
    private String title;
    private String text;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Notebook notebook;

    private Date lastModifiedOn;

//  Required for @Entity
    public Note() {
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
        this.id = UUID.randomUUID();
        this.lastModifiedOn = new Date();
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

}
