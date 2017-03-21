package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Subject implements Serializable {

    /** Fields */
    @Id
    private Long id;
    private String name;

    /** Constructors */
    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    /** Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
