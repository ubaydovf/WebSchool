package app.controllers.rest;

import app.interfaces.ClazzService;
import app.interfaces.StudentService;
import app.models.Clazz;
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
    private StudentService studentService;

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Clazz>> getClasses(){
        return new ResponseEntity<>(clazzService.getClazzes(), HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClass(@PathVariable Long id){
        return new ResponseEntity<>(clazzService.getClazzById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public ResponseEntity<?> createClass(@RequestBody Clazz clazz){
        return new ResponseEntity<>(clazzService.addClazz(clazz), HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClass(@RequestBody Clazz clazz){
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClass(@PathVariable Long id){
        clazzService.deleteClazzById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    /** ----------- //// ---------- /////////// ------------ ////////// -------- */

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
