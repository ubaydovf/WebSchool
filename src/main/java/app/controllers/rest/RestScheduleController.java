package app.controllers.rest;

import app.interfaces.ScheduleDayService;
import app.interfaces.ScheduleService;
import app.interfaces.ScheduleWeekService;
import app.interfaces.SubjectService;
import app.models.schedule.Schedule;
import app.models.schedule.ScheduleDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleWeekService scheduleWeekService;
    @Autowired
    private ScheduleDayService scheduleDayService;
    @Autowired
    private SubjectService subjectService;

    /* Get a schedule */
    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public ResponseEntity<List<Schedule>> getStudents(){
        return new ResponseEntity<>(scheduleService.getSchedules(), HttpStatus.OK);
    }

    /* Get a schedule by ID */
    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSchedule(@PathVariable Long id){
//        subjectService.addSubject(new Subject("Math"));
//        subjectService.addSubject(new Subject("French"));
//        subjectService.addSubject(new Subject("Russian"));
//        subjectService.addSubject(new Subject("English"));
//        subjectService.addSubject(new Subject("History"));
//        subjectService.addSubject(new Subject("Biology"));
//
//        List<Subject> list = new ArrayList<>();
//        list.add(subjectService.getSubjectById(1L));
//        list.add(subjectService.getSubjectById(2L));
//        list.add(subjectService.getSubjectById(3L));
//        list.add(subjectService.getSubjectById(4L));
//        ScheduleDay day = new ScheduleDay(list);
//
//        list = new ArrayList<>();
//        list.add(subjectService.getSubjectById(2L));
//        list.add(subjectService.getSubjectById(6L));
//        list.add(subjectService.getSubjectById(5L));
//        list.add(subjectService.getSubjectById(3L));
//        ScheduleDay day1 = new ScheduleDay(list);
//
//        list = new ArrayList<>();
//        list.add(subjectService.getSubjectById(5L));
//        list.add(subjectService.getSubjectById(2L));
//        list.add(subjectService.getSubjectById(3L));
//        list.add(subjectService.getSubjectById(1L));
//        list.add(subjectService.getSubjectById(4L));
//        ScheduleDay day2 = new ScheduleDay(list);
//
//        scheduleDayService.updateScheduleDay(day);
//        scheduleDayService.updateScheduleDay(day1);
//        scheduleDayService.updateScheduleDay(day2);
//
//        ScheduleWeek week = new ScheduleWeek();
//        week.setScheduleDay(Day.MONDAY.name(), day);
//        week.setScheduleDay(Day.TUESDAY.name(), day1);
//        week.setScheduleDay(Day.WEDNESDAY.name(), null);
//        week.setScheduleDay(Day.THURSDAY.name(), null);
//        week.setScheduleDay(Day.FRIDAY.name(), day2);
//        week.setScheduleDay(Day.SATURDAY.name(), null);
//        week.setScheduleDay(Day.SUNDAY.name(), null);
//        scheduleWeekService.updateSchedule(week);
//
//        ScheduleWeek week1 = new ScheduleWeek();
//        week1.setScheduleDay(Day.TUESDAY.name(), day);
//        week1.setScheduleDay(Day.WEDNESDAY.name(), day1);
//        week1.setScheduleDay(Day.SATURDAY.name(), day2);
//        week1.setScheduleDay(Day.SUNDAY.name(), day2);
//        week1.setScheduleDay(Day.THURSDAY.name(), day2);
//        week1.setScheduleDay(Day.MONDAY.name(), null);
//        week1.setScheduleDay(Day.FRIDAY.name(), null);
//        scheduleWeekService.updateSchedule(week1);
//
//        ScheduleWeek week2 = new ScheduleWeek();
//        week2.setScheduleDay(Day.THURSDAY.name(), day);
//        week2.setScheduleDay(Day.FRIDAY.name(), day1);
//        week2.setScheduleDay(Day.MONDAY.name(), day2);
//        week2.setScheduleDay(Day.TUESDAY.name(), null);
//        week2.setScheduleDay(Day.WEDNESDAY.name(), null);
//        week2.setScheduleDay(Day.SUNDAY.name(), null);
//        week2.setScheduleDay(Day.SATURDAY.name(), null);
//        scheduleWeekService.updateSchedule(week2);
//
//        Schedule schedule = new Schedule();
//        schedule.setScheduleWeek("11G", week);
//        schedule.setScheduleWeek("10G", week1);
//        schedule.setScheduleWeek("9G", week2);
//
//        scheduleService.updateSchedule(schedule);
        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
    }

    /* Create a Schedule */
    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public ResponseEntity<?> createSchedule(@RequestBody Schedule schedule){
        return new ResponseEntity<>(scheduleService.addSchedule(schedule), HttpStatus.OK);
    }

    /* Edit a scheduleWeek */
    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubject(@RequestBody Schedule schedule){
        return new ResponseEntity<>(scheduleService.updateSchedule(schedule), HttpStatus.OK);
    }

    /* Delete a schedule */
    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubject(@PathVariable Long id){
        scheduleService.deleteScheduleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* ----------------------------------------------------------------------------------- */
    @RequestMapping(value = "/classes/{clId}/schedule/{schId}", method = RequestMethod.GET)
    public ResponseEntity<?> getClass(@PathVariable Long clId, @PathVariable Long schId){
        Schedule schedule = scheduleService.getScheduleById(schId);
        if (schedule != null) {
            return  new ResponseEntity<>(schedule.getScheduleWeek(clId), HttpStatus.OK);
            }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/classes/{clId}/schedule/{schId}/{weekDay}", method = RequestMethod.GET)
    public ResponseEntity<?> getClass(@PathVariable Long clId,
                                      @PathVariable Long schId, @PathVariable String weekDay){

        weekDay = weekDay.toUpperCase();

        Schedule schedule = scheduleService.getScheduleById(schId);
        if (schedule != null) {
            ScheduleDay scheduleDay = schedule.getScheduleDay(clId, weekDay);
            if (scheduleDay != null) {
                return  new ResponseEntity<>(scheduleDay, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
