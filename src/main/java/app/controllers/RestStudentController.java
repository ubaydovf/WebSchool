package app.controllers;

import app.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestStudentController {

    /** Get All Students */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents(){

        /** Here is has to be code to get a Students */
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /** Get Student by ID */
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id){

        /** Here is has to be code to get a Student by ID */
        return new ResponseEntity<>(new Student(), HttpStatus.OK);
    }

    /** Create a Student */
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student){

        /** Here is has to be code to create a student */
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
