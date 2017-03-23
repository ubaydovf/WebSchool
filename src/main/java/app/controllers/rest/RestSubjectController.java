package app.controllers.rest;

import app.interfaces.SubjectService;
import app.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestSubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getStudents(){
        return new ResponseEntity<>(subjectService.getSubjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSubject(@PathVariable Long id){
        return new ResponseEntity<>(subjectService.getSubjectById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public ResponseEntity<?> createSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.addSubject(subject), HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.updateSubject(subject), HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
