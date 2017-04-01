package app.models.schedule;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private Map<Long, ScheduleWeek> weekHashMap = new HashMap<>();

    /* Constructors */
    public Schedule() {
    }

    public Schedule(Map<Long, ScheduleWeek> schedule) {
        this.weekHashMap = schedule;
    }

    /* ----------------------------------- Methods -------------------------------------*/

    /* ---------------- Methods for Schedule Week -------------- */
    public ScheduleWeek getScheduleWeek(Long classId) {
        return weekHashMap.get(classId);
    }

    public void setScheduleWeek(Long classId, ScheduleWeek scheduleWeek) {
        weekHashMap.put(classId, scheduleWeek);
    }

    /* ---------------- Methods for Schedule Day --------------- */
    public ScheduleDay getScheduleDay(Long classId, String weekDay) {
        return weekHashMap.get(classId).getScheduleDay(weekDay);
    }

    public void setScheduleDay(String className, String weekDay, ScheduleDay scheduleDay) {
        weekHashMap.get(className).setScheduleDay(weekDay, scheduleDay);
    }

    /* ----------------  Getters and Setters -------------------- */
    public Long getId() {
        return id;
    }

    public Map<Long, ScheduleWeek> getWeekHashMap() {
        return weekHashMap;
    }

    public void setWeekHashMap(Map<Long, ScheduleWeek> weekHashMap) {
        this.weekHashMap = weekHashMap;
    }
}
