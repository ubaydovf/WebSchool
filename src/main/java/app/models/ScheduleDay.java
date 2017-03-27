package app.models;

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
    private List<Subject> schedule = new ArrayList<>();

    /** Constructors */
    public ScheduleDay() {
    }

    public ScheduleDay(List<Subject> scheduleDay) {
        this.schedule = scheduleDay;
    }

    /** Methods */
    public void addSubject(Subject subject) {
        schedule.add(subject);
    }

    public void removeSubject(Subject subject) {
        schedule.remove(subject);
    }

    /** Getter and Setters */
    public Long getId() {
        return id;
    }

    public List<Subject> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Subject> schedule) {
        this.schedule = schedule;
    }
}
