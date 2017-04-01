package app.services;

import app.interfaces.ScheduleDayService;
import app.models.schedule.ScheduleDay;
import app.repositories.ScheduleDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleDayServiceImpl implements ScheduleDayService {

    @Autowired
    private ScheduleDayRepository scheduleDayRepository;

    @Override
    public ScheduleDay addScheduleDay(ScheduleDay schedule) {
        return scheduleDayRepository.save(schedule);
    }

    @Override
    public ScheduleDay getScheduleDayById(Long id) {
        return scheduleDayRepository.findOne(id);
    }

    @Override
    public List<ScheduleDay> getScheduleDays() {
        return scheduleDayRepository.findAll();
    }

    @Override
    public ScheduleDay updateScheduleDay(ScheduleDay schedule) {
        return scheduleDayRepository.save(schedule);
    }

    @Override
    public void deleteScheduleDayById(Long id) {
        scheduleDayRepository.delete(id);
    }
}
