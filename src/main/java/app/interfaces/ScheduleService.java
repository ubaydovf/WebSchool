package app.interfaces;

import app.models.schedule.Schedule;

import java.util.List;

public interface ScheduleService {

    Schedule addSchedule(Schedule schedule);

    Schedule getScheduleById(Long id);

    List<Schedule> getSchedules();

    Schedule updateSchedule(Schedule schedule);

    void deleteScheduleById(Long id);
}
