package app.controllers.rest;

import app.interfaces.ClazzService;
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

}
