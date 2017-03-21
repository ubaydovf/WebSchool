package app.controllers.rest;

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

    /** Get All Students */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents(){
        /** Here is has to be code to get a Students */
        return new ResponseEntity(studentService.getStudents(), HttpStatus.OK);
    }

    /** Get Student by ID */
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        /** Here is has to be code to get a Student by ID */
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    /** Create a Student */
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        /** Here is has to be code to create a student */
//        student.setSelfClazz(student.getSelfClazz());
        return new ResponseEntity(studentService.addStudent(student), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student){

        /** Here is has to be code to create a student */
        return new ResponseEntity(studentService.updateStudent(student), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){

        /** Here is has to be code to create a student */
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
