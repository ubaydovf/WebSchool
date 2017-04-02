package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Awards implements Serializable{

    /** Fields */
    @Id
    private Long id;
    private Long ownerId;

    @ManyToMany
    private List<Medal> medalsList;

    /** Constructors */
    public Awards() {
    }

    public Awards(List<Medal> medalsList) {
        this.medalsList = medalsList;
    }

    /** Setter and Getters */
    public List<Medal> getMedalsList() {
        return medalsList;
    }

    public void setMedalsList(List<Medal> medalsList) {
        this.medalsList = medalsList;
    }

    public Long getId() {
        return id;
    }

    /** Methods */
    public void addMedal(Medal medal){
        medalsList.add(medal);
    }

    public void removeMedal(Medal medal){
        medalsList.remove(medal);
    }

}
