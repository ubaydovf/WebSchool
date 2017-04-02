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

    /** ----------------------------- /subjects --------------------------------- */
    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjects(){
        List<Subject> subjects = subjectService.getSubjects();
        if (subjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSubject(@PathVariable Long id){
        Subject subject = subjectService.getSubjectById(id);
        if (subject == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public ResponseEntity<?> createSubject(@RequestBody Subject subject){
        if (subject == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(subjectService.addSubject(subject), HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject){
        if (subject == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(subjectService.updateSubject(subject), HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
