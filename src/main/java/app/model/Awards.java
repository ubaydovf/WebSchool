package app.model;

import java.util.List;

public class Awards {

    /** Fields */
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
