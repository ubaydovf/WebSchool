package app.controllers.rest;

import app.interfaces.BookService;
import app.interfaces.StudentService;
import app.models.Book;
import app.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{classId}/students/{studentId}/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getStudentBooks(@PathVariable Long studentId) {
        return new ResponseEntity<>(bookService.findBookByHoldersId(studentId), HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{classId}/students/{studentId}/books", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudentBook(@RequestBody Book book, @PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
//        Adding book to Book table
        bookService.addBook(book);
//        Saving added Book to student
        student.addBook(book);
//        Saving modified student and returning student
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

//    @RequestMapping(value = "/classes/{classId}/students/{studentId}/books", method = RequestMethod.GET)
//    public ResponseEntity<List<Book>> getStudentBooks(@PathVariable Long studentId){
//        return new ResponseEntity<>(bookService.findBookByHoldersId(studentId), HttpStatus.OK);
//    }

}