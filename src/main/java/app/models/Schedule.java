package app.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Schedule implements Serializable {

    /** Fields */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Map<String, ScheduleDay> scheduleWeek = new HashMap<>();

    /** Constructors */

    public Schedule() {
    }

    public Schedule(Map<String, ScheduleDay> scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }

    /** Methods */
    public void setScheduleDay(Day day, ScheduleDay scheduleday) {
        scheduleWeek.put(day.name(), scheduleday);
    }

    public void clearScheduleDay(Day day){
        scheduleWeek.remove(day.name());
    }

    public ScheduleDay getScheduleDay(Day day) {
        return scheduleWeek.get(day.name());
    }

    /** Getter and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, ScheduleDay> getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(Map<String, ScheduleDay> scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }
}
