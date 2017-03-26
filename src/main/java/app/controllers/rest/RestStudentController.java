package app.controllers.rest;

import app.interfaces.ClazzService;
import app.interfaces.StudentService;
import app.models.Clazz;
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

    /** Get All Students */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents(){
        /** Here is has to be code to get a Students */
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
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
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student){

        /** Here is has to be code to create a student */
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){

        /** Here is has to be code to create a student */
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /** ----------- //// ---------- /////////// ------------ ////////// -------- */

    /** Get students by Class*/
    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getClassStudents(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findStudentByClazzId(id), HttpStatus.OK);
    }

    /** Put a students into a Class*/
    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.PUT)
    public ResponseEntity<Clazz> addStudentToClass(@RequestBody List<Student> students, @PathVariable Long id){
        Clazz clazz = clazzService.getClazzById(id);    /* Get a class by {id} */
//        List<Student> studentList = studentService.findStudentByClazzId(clazz.getId());

//      Iteration over student list and adding reference each other
        for (Student student : students) {
            Student tmp = studentService.getStudentById(student.getId()); /* Пусть пока будет так */
            clazz.addStudent(tmp);                      /* Adding student to class */
            tmp.setSelfClazz(clazz.getId());                    /* Adding class to student */
            studentService.updateStudent(tmp);          /* Saving updated student */
        }

        /* Saving updated class and return it as response */
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }

    /** Delete a student/students from Class */
    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.DELETE)
    public ResponseEntity<Clazz> deleteStudentFromClass(@RequestBody List<Student> studentList, @PathVariable Long id){
        Clazz clazz = clazzService.getClazzById(id);    /* Get a class by {id} */

//      Iteration over student list and deleting reference to each other
        for (Student student : studentList) {
            Student student1 = studentService.getStudentById(student.getId());
            clazz.removeStudent(student1);                      /* Remove student from class */
            student1.setSelfClazz(null);                    /* Remove class from student*/
            studentService.updateStudent(student1);          /* Saving updated student */
        }

//        /* Saving updated class and return it as response */
        return new ResponseEntity<>(clazzService.updateClazz(clazz), HttpStatus.OK);
    }
}
