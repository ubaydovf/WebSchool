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
public class RestClazzController {

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClasses() {
        List<Clazz> clazzes = clazzService.getClazzes();
        if (clazzes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clazzes, HttpStatus.OK);
    }

    /**
     * ---------------------- /classes ----------------------
     */

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClass(@PathVariable Long id) {
        Clazz clazzById = clazzService.getClazzById(id);
        if (clazzById != null) {
            return new ResponseEntity<>(clazzById, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public ResponseEntity<?> createClass(@RequestBody Clazz clazz) {
        if (clazz != null) {
            return new ResponseEntity<>(clazzService.addClazz(clazz), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClass(@RequestBody Clazz clazz) {

        Clazz clazz1 = clazzService.updateClazz(clazz);
        if (clazz1 != null) {
            return new ResponseEntity<>(clazz1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClass(@PathVariable Long id) {
        clazzService.deleteClazzById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /** ------------------------- /teacher/{id}/classes --------------------------- */
    /* Get Classes by Teacher ID */
    @RequestMapping(value = "/teacher/{id}/classes", method = RequestMethod.GET)
    public ResponseEntity<?> getClassByTeacherId(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        List<Clazz> allByTeacherId = clazzService.findAllByTeacherId(teacher.getId());
        if (!allByTeacherId.isEmpty()) {
            return new ResponseEntity<>(allByTeacherId, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    /** Get a class Captain */
//    @RequestMapping(value = "/classes/{id}/captain", method = RequestMethod.GET)
//    public ResponseEntity<Student> getClassCaptain(@PathVariable Long id) {
//        Clazz clazz = clazzService.getClazzById(id);
//        return new ResponseEntity<>(clazz.getCaptain(), HttpStatus.OK);
//    }
//
//    /** Put a class Captain */
//    @RequestMapping(value = "/classes/{id}/captain", method = RequestMethod.PUT)
//    public ResponseEntity<Clazz> setClassCaptain(@RequestBody Student student, @PathVariable Long id) {
//        Clazz clazz = clazzService.getClazzById(id);
//        /* Checking is there any captain already in a class ? if yes, remove him */
//        if (clazz.getCaptain() != null) {
//            clazz.getCaptain().setCaptain(null);
//        }
//
//        Student student1 = studentService.getStudentById(student.getId());
//        student1.setCaptain(true);
//        studentService.updateStudent(student1);
//        clazz.setCaptain(student1);
//
//        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
//    }
//
//    /** Remove a class Captain */
//    @RequestMapping(value = "/classes/{id}/captain", method = RequestMethod.DELETE)
//    public ResponseEntity<Clazz> removeClassCaptain(@RequestBody Student student, @PathVariable Long id) {
//        Clazz clazz = clazzService.getClazzById(id);
//        Student student1 = studentService.getStudentById(student.getId());
//        student1.setCaptain(false);
//        studentService.updateStudent(student1);
//        clazz.setCaptain(null);
//
//        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
//    }
    }
}
