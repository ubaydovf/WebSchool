package app.controllers.rest;

import app.interfaces.ScheduleDayService;
import app.interfaces.ScheduleService;
import app.interfaces.SubjectService;
import app.models.Schedule;
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
        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
    }
    /* Create a empty Schedule*/
    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public ResponseEntity<?> createSubject(@RequestBody Schedule schedule){

        /*Map<String, ScheduleDay> scheduleWeek = schedule.getScheduleWeek();
        Iterator<Map.Entry<String, ScheduleDay>> iterator = scheduleWeek.entrySet().iterator();
        ScheduleDay tmp;
        while (iterator.hasNext()) {
            tmp = iterator.next().getValue();
            scheduleDayService.addScheduleDay(tmp);
        }*/
        return new ResponseEntity<>(scheduleService.addSchedule(schedule), HttpStatus.OK);
    }
    /* Edit a schedule */
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
}
