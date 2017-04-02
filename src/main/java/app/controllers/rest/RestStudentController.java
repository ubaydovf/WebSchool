package app.controllers.rest;

import app.interfaces.ClazzService;
import app.interfaces.StudentService;
import app.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestStudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;

    /** ----------------------------- /students --------------------------------- */
    /** Get All Students */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents(){
        /* Here is has to be code to get a Students */
        List<Student> students = studentService.getStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /** Get Student by ID */
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        /* Here is has to be code to get a Student by ID */
        Student studentById = studentService.getStudentById(id);
        if (studentById != null) {
            return new ResponseEntity<>(studentById, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /** Create a Student */
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        /* Here is has to be code to create a student */
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    /** Edit a Student */
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        /* Here is has to be code to create a student */
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    /** Delete a Student */
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        /* Here is has to be code to delete a student */
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /** ----------------------------- /classes/{id}/students --------------------------------- */
    /* Operation with students to class */

    /** Get students by Class */
    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getClassStudents(@PathVariable Long id){
        List<Student> studentByClazzId = studentService.findStudentByClazzId(id);
        if (studentByClazzId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentByClazzId, HttpStatus.OK);
    }

    /** Put a students into a Class */
    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.PUT)
    public ResponseEntity<List<Student>> addStudentToClass(@RequestBody Student student, @PathVariable Long id){
        Student studentById = studentService.getStudentById(student.getId());  /* Finding student by ID */
        if (studentById != null) {
            studentById.setSelfClazz(id);                                          /* Setting student Class  */
            studentService.updateStudent(studentById);                             /* Saving updated Student */
            return new ResponseEntity<>(studentService.findStudentByClazzId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /** Delete a student/students from Class */
    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.DELETE)
    public ResponseEntity<List<Student>> deleteStudentFromClass(@RequestBody Student student, @PathVariable Long id){
        Student student1 = studentService.getStudentById(student.getId());
        if (student1 != null) {
            student1.setSelfClazz(null);
            studentService.updateStudent(student1);
            return new ResponseEntity<>(studentService.findStudentByClazzId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
