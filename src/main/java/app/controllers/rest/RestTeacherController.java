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

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> getTeachers(){
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeacher(@PathVariable Long id){
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.updateTeacher(teacher), HttpStatus.OK);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* ----------- //// ---------- /////////// ------------ ////////// -------- */

    /** Get class teacher */
    @RequestMapping(value = "/classes/{id}/teacher", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getClassTeacher(@PathVariable Long id){
        return new ResponseEntity<>(teacherService.findTeacherByClazzesId(id), HttpStatus.OK);
    }

    /** Put a teacher into a Class*/
    @RequestMapping(value = "/classes/{id}/teacher", method = RequestMethod.PUT)
    public ResponseEntity<Clazz> addTeacherToClass(@RequestBody Teacher teacher, @PathVariable Long id){
        Clazz clazz = clazzService.getClazzById(id);    /* Get a class by {id} */
        /* Checking is there already teacher added in class, if yes, then remove teacher */
        if (clazz.getClassTeacher() != null) {
            teacherService.getTeacherById(clazz.getClassTeacher()).removeClass(clazz);
        }

        Teacher teacher1 = teacherService.getTeacherById(teacher.getId()); /* Get a teacher by {id} */
        clazz.setClassTeacher(teacher1.getId());    /* add teacher to class */
        teacher1.addClass(clazz);                   /* add class to teacher */
        teacherService.updateTeacher(teacher1);     /* update teacher */

        /* Saving updated class and return it as response */
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }

    /** Delete a teacher from Class */
    @RequestMapping(value = "/classes/{id}/teacher", method = RequestMethod.DELETE)
    public ResponseEntity<Clazz> deleteStudentFromClass(@RequestBody Teacher teacher, @PathVariable Long id){
        Clazz clazz = clazzService.getClazzById(id);    /* Get a class by {id} */
        Teacher teacher1 = teacherService.getTeacherById(teacher.getId());
        teacher1.removeClass(clazz); // remove class from teacher's class list
        clazz.setClassTeacher(null);    //remove teacher from class
        teacherService.updateTeacher(teacher1);  /* update teacher */

        /* Saving updated class and return it as response */
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }

}
