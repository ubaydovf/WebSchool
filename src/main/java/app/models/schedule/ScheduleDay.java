package app.models.schedule;

import app.models.Subject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ScheduleDay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Subject> scheduleDayMap = new ArrayList<>();

    /** Constructors */
    public ScheduleDay() {
    }

    public ScheduleDay(List<Subject> scheduleDay) {
        this.scheduleDayMap = scheduleDay;
    }

    /** Methods */
    public void addSubject(Subject subject) {
        scheduleDayMap.add(subject);
    }

    public void removeSubject(Subject subject) {
        scheduleDayMap.remove(subject);
    }

    /** Getter and Setters */
    public Long getId() {
        return id;
    }

    public List<Subject> getScheduleDayMap() {
        return scheduleDayMap;
    }

    public void setScheduleDayMap(List<Subject> scheduleDayMap) {
        this.scheduleDayMap = scheduleDayMap;
    }
}
