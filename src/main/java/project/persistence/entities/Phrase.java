package project.persistence.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * The class for the Phrase itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "phrase") // If you want to specify a table name, you can do so here
public class Phrase extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;
    private String description;
    private Long upvotes;
    private Long downvotes;
    private Long hotness;


    Phrase() {
    } // JPA only

    public Phrase(String word, String description, Long upvotes, Long downvotes, Long hotness, Date dateAdded) {
        this.word = word;
        this.description = description;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.hotness = hotness;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }

    public Long getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Long downvotes) {
        this.downvotes = downvotes;
    }

    public Long getHotness() {
        return hotness;
    }

    public void setHotness(Long hotness) {
        this.hotness = hotness;
    }
}
