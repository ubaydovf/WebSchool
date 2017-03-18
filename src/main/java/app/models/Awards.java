package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Awards implements Serializable{

    /** Fields */
    @Id
    private Long id;
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

    /** Methods */
    public void addMedal(Medal medal){
        medalsList.add(medal);
    }

    public void removeMedal(Medal medal){
        medalsList.remove(medal);
    }

}
