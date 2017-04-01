//package app.controllers.rest;
//
//import app.interfaces.ScheduleDayService;
//import app.interfaces.ScheduleWeekService;
//import app.interfaces.SubjectService;
//import app.models.schedule.ScheduleWeek;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class RestScheduleWeekController {
//
//    @Autowired
//    private ScheduleWeekService scheduleService;
//    @Autowired
//    private ScheduleDayService scheduleDayService;
//    @Autowired
//    private SubjectService subjectService;
//
//    /* Get a schedule */
//    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
//    public ResponseEntity<List<ScheduleWeek>> getStudents(){
//        return new ResponseEntity<>(scheduleService.getSchedules(), HttpStatus.OK);
//    }
//    /* Get a schedule by ID */
//    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> getWeekHashMap(@PathVariable Long id){
//        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
//    }
//    /* Create a empty ScheduleWeek*/
//    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
//    public ResponseEntity<?> createSubject(@RequestBody ScheduleWeek scheduleWeek){
//
//        /*Map<String, ScheduleDay> scheduleWeek = scheduleWeek.getScheduleWeekMap();
//        Iterator<Map.Entry<String, ScheduleDay>> iterator = scheduleWeek.entrySet().iterator();
//        ScheduleDay tmp;
//        while (iterator.hasNext()) {
//            tmp = iterator.next().getValue();
//            scheduleDayService.addScheduleDay(tmp);
//        }*/
//        return new ResponseEntity<>(scheduleService.addSchedule(scheduleWeek), HttpStatus.OK);
//    }
//    /* Edit a scheduleWeek */
//    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateSubject(@RequestBody ScheduleWeek scheduleWeek){
//        return new ResponseEntity<>(scheduleService.updateSchedule(scheduleWeek), HttpStatus.OK);
//    }
//    /* Delete a schedule */
//    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteSubject(@PathVariable Long id){
//        scheduleService.deleteScheduleById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
