package app.models.schedule;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ScheduleWeek implements Serializable {

    /** Fields */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Map<String, ScheduleDay> scheduleWeekMap = new HashMap<>();

    /** Constructors */

    public ScheduleWeek() {
    }

    public ScheduleWeek(Map<String, ScheduleDay> scheduleWeek) {
        this.scheduleWeekMap = scheduleWeek;
    }

    /** Methods */
    public void setScheduleDay(String day, ScheduleDay scheduleday) {
        scheduleWeekMap.put(day, scheduleday);
    }

    public void clearScheduleDay(String day){
        scheduleWeekMap.remove(day);
    }

    public ScheduleDay getScheduleDay(String day) {
        return scheduleWeekMap.get(day);
    }

    /** Getter and Setters */
    public Long getId() {
        return id;
    }

    public Map<String, ScheduleDay> getScheduleWeekMap() {
        return scheduleWeekMap;
    }

    public void setScheduleWeekMap(Map<String, ScheduleDay> scheduleWeekMap) {
        this.scheduleWeekMap = scheduleWeekMap;
    }
}
