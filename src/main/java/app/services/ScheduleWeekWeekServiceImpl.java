//package app.services;
//
//import app.interfaces.ScheduleWeekService;
//import app.models.schedule.ScheduleWeek;
//import app.repositories.ScheduleWeekRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ScheduleWeekWeekServiceImpl implements ScheduleWeekService {
//
//    @Autowired
//    private ScheduleWeekRepository scheduleWeekRepository;
//
//    @Override
//    public ScheduleWeek addSchedule(ScheduleWeek scheduleWeek) {
//        return scheduleWeekRepository.save(scheduleWeek);
//    }
//
//    @Override
//    public ScheduleWeek getScheduleById(Long id) {
//        return scheduleWeekRepository.findOne(id);
//    }
//
//    @Override
//    public List<ScheduleWeek> getSchedules() {
//        return scheduleWeekRepository.findAll();
//    }
//
//    @Override
//    public ScheduleWeek updateSchedule(ScheduleWeek scheduleWeek) {
//        return scheduleWeekRepository.save(scheduleWeek);
//    }
//
//    @Override
//    public void deleteScheduleById(Long id) {
//        scheduleWeekRepository.delete(id);
//    }
//}
