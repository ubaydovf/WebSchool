package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Medal implements Serializable {

    /** Fields */
    @Id
    private Long id;
    private String name;
    private String description;
    private Integer level;



    /** Constructors */
    public Medal() {
    }

    public Medal(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
