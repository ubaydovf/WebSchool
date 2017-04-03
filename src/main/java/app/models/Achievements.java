package app.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Achievements implements Serializable{

    /** Fields */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Map<Long, Achievement> achievementList = new HashMap<>();

    /** Constructors */
    public Achievements() {
    }

    /** Setter and Getters */
    public Map<Long, Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(Map<Long, Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    public Long getId() {
        return id;
    }

    /** Methods */
    public void addAchievement(Achievement medal){
        achievementList.put(medal.getId(), medal);
    }

    public void removeAchievement(Achievement medal){
        achievementList.remove(medal.getId());
    }

}
