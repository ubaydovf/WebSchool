package app.controllers.rest;

import app.interfaces.ClazzService;
import app.interfaces.TeacherService;
import app.models.Clazz;
import app.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestTeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClazzService clazzService;

    /* Get a teachers */
    /** ----------------------------- /teachers --------------------------------- */
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> getTeachers(){
        List<Teacher> teachers = teacherService.getTeachers();
        if (teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    /* Get a teacher by Id */
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeacher(@PathVariable Long id){
        Teacher teacherById = teacherService.getTeacherById(id);
        if (teacherById == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teacherById, HttpStatus.OK);
    }

    /* Create a teacher */
    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher){
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
    }

    /* Edit a teacher */
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher){
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teacherService.updateTeacher(teacher), HttpStatus.OK);
    }

    /* Delete teacher */
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* ----------------------------- /classes/{id}/teacher --------------------------------- */
    /** Get class teacher */
    @RequestMapping(value = "/classes/{id}/teacher", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getClassTeacher(@PathVariable Long id){
        Teacher teacher = teacherService.findTeacherByClazzesId(id);
        if (teacher == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    /** Put a teacher into a Class*/
    @RequestMapping(value = "/classes/{id}/teacher", method = RequestMethod.PUT)
    public ResponseEntity<Clazz> addTeacherToClass(@RequestBody Teacher teacher, @PathVariable Long id){
        Clazz clazz = clazzService.getClazzById(id);    /* Get a class by {id} */
        /* Checking is there already teacher added in class, if yes, then remove teacher */
        Teacher teacher1 = null;
        if (teacher != null) {
            teacher1 = teacherService.getTeacherById(teacher.getId()); /* Get a teacher by {id} */
        }

        if (teacher1 == null || clazz == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clazz.setTeacherId(teacher1.getId());    /* add teacher to class */

        /* Saving updated class and return it as response */
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }

    /** Delete a teacher from Class */
    @RequestMapping(value = "/classes/{id}/teacher", method = RequestMethod.DELETE)
    public ResponseEntity<Clazz> deleteTeacherFromClass(@PathVariable Long id){
        Clazz clazz = clazzService.getClazzById(id);    /* Get a class by {id} */
        if (clazz == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clazz.setTeacherId(null);    //remove teacher from class

        /* Saving updated class and return it as response */
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }

}
