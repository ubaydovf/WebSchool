//package app.controllers.rest;
//
//import app.interfaces.ScheduleDayService;
//import app.interfaces.ScheduleWeekService;
//import app.interfaces.SubjectService;
//import app.models.Day;
//import app.models.schedule.ScheduleWeek;
//import app.models.schedule.ScheduleDay;
//import app.models.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class RestScheduleDayController {
//
//    @Autowired
//    private ScheduleWeekService scheduleService;
//    @Autowired
//    private ScheduleDayService scheduleDayService;
//    @Autowired
//    private SubjectService subjectService;
//
//    /* Get a schedule days from schedule */
//    @RequestMapping(value = "/schedules/{id}/weekDays", method = RequestMethod.GET)
//    public ResponseEntity<List<ScheduleDay>> getScheduleDays(@PathVariable Long id){
//        ScheduleWeek schedule = scheduleService.getScheduleById(id);
//        Map<String, ScheduleDay> scheduleWeek = schedule.getScheduleWeekMap();
//        List<ScheduleDay> scheduleDays = new ArrayList<>(scheduleWeek.values());
//        return new ResponseEntity<>(scheduleDays, HttpStatus.OK);
//    }
//
//    /* Get a scheduleDay by ID */
//    @RequestMapping(value = "/schedules/{scheduleId}/weekDays/{dayId}", method = RequestMethod.GET)
//    public ResponseEntity<?> getScheduleDayMap(@PathVariable Long scheduleId, @PathVariable String dayId){
//        ScheduleDay temp = null;
//        ScheduleWeek scheduleWeek = scheduleService.getScheduleById(scheduleId);
//        for (Day day : Day.values()) {
//            if (dayId.equalsIgnoreCase(day.name())) {
//                temp = scheduleWeek.getScheduleDayMap(day.name());
//            }
//        }
//        return new ResponseEntity<>(temp, HttpStatus.OK);
//    }
//
//    /* Create a ScheduleDay */
//    /*
//    @RequestMapping(value = "/schedules/{id}/weekDays", method = RequestMethod.POST)
//    public ResponseEntity<?> createScheduleDay(@PathVariable Long id, @RequestBody ScheduleDay scheduleDays){
//        ScheduleWeek schedule = scheduleService.getScheduleById(id);
//        schedule.setScheduleDayMap();
//        Map<String, ScheduleDay> scheduleWeek = schedule.getScheduleWeekMap();
//        Iterator<Map.Entry<String, ScheduleDay>> iterator = scheduleWeek.entrySet().iterator();
//        ScheduleDay tmp;
//        while (iterator.hasNext()) {
//            tmp = iterator.next().getValue();
//            scheduleDayService.addScheduleDay(tmp);
//        }
//        return new ResponseEntity<>(scheduleService.addSchedule(schedule), HttpStatus.OK);
//    }
//    */
//
//    /* Edit a scheduleDay */
//    @RequestMapping(value = "/schedules/{scheduleId}/weekDays/{dayId}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateScheduleDay(@PathVariable Long scheduleId,
//                                               @RequestBody ScheduleDay scheduleDay, @PathVariable String dayId) {
//        /* Getting  a scheduleWeek */
//        ScheduleWeek scheduleWeek = scheduleService.getScheduleById(scheduleId);
//        List<Subject> tmpSubjects = scheduleDay.getScheduleDayMap();
//        List<Subject> subjects = new ArrayList<>();
//
//        for (Subject tmpSubject : tmpSubjects) {
//            subjects.add(subjectService.getSubjectById(tmpSubject.getId()));
//        }
//
//        scheduleDay.setScheduleDayMap(subjects);
//        scheduleDayService.updateScheduleDay(scheduleDay);
//        /* Пока тут происходит магия, позже обьясню */
////        scheduleDayService.getScheduleDayById(scheduleDay.getId()); /* Getting a scheduleWeek day */
//
//        /* Searching for scheduleWeek day in Days List [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY] */
//        for (Day day : Day.values()) {
//            if (dayId.equalsIgnoreCase(day.name())) {
//                scheduleWeek.setScheduleDayMap(day.name(), scheduleDay); /* And set it to necessary Day */
//            }
//        }
//        /* Finally update the scheduleWeek to save the changes! */
//        return new ResponseEntity<>(scheduleService.updateSchedule(scheduleWeek), HttpStatus.OK);
//    }
//
//    /* Delete a scheduleDay */
//    @RequestMapping(value = "/schedules/{scheduleId}/weekDays/{dayId}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteScheduleDay(@PathVariable Long scheduleId, @PathVariable String dayId){
//        ScheduleWeek scheduleWeek = scheduleService.getScheduleById(scheduleId);
////        scheduleWeek.getScheduleWeekMap().remove()
//        for (Day day : Day.values()) {
//            if (dayId.equalsIgnoreCase(day.name())) {
//                scheduleWeek.getScheduleWeekMap().remove(day.name());
//                scheduleService.updateSchedule(scheduleWeek);
//            }
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
