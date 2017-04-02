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

    /** -------------------------    /books     ----------------------- */

    /* Get all Books */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> books = bookService.getBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    /* Get Book by ID */
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        Book bookById = bookService.getBookById(id);
        if (bookById != null) {
            return new ResponseEntity<>(bookById, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Create a book */
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        if (book != null) {
            return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Edit a book by ID */
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        if (book != null) {
            return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /* Delete a book by ID */
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /** -------------------------    /classes/{clId}/students/{stId}     ----------------------- */

    //    Get students Books
    @RequestMapping(value = "/classes/{classId}/students/{studentId}/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getStudentBooks(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        List<Book> books;
        if (student != null ) {
            books = student.getBooks();
            if (!books.isEmpty()) {
                return new ResponseEntity<>(books, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    Put a book into student book list
    @RequestMapping(value = "/classes/{classId}/students/{studentId}/books", method = RequestMethod.PUT)
    public ResponseEntity<List<Book>> addBookToStudent(@RequestBody Book book, @PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        Book bookById = bookService.getBookById(book.getId());
        if (student != null && bookById != null) {
//        Adding Book to student
            student.addBook(bookById);      /* Adding Book to student */
            return new ResponseEntity<>(studentService.updateStudent(student).getBooks(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //    Remove a book from student book list
    @RequestMapping(value = "/classes/{classId}/students/{studentId}/books", method = RequestMethod.DELETE)
    public ResponseEntity<List<Book>> removeStudentBook(@RequestBody Book book, @PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        Book book1 = bookService.getBookById(book.getId());
        if (student != null && book1 != null) {
            student.removeBook(book1);              /* Removing Book from student */
            studentService.updateStudent(student);  /* Save updated student */
            return new ResponseEntity<>(student.getBooks(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    /** -------------------------     /students/{id}/books    -------------------------*/

    //    Get students Books
    @RequestMapping(value = "/students/{id}/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getStBooks(@PathVariable Long id) {
        return getStudentBooks(id);
    }

    //    Put a book into student book list
    @RequestMapping(value = "/students/{id}/books", method = RequestMethod.PUT)
    public ResponseEntity<List<Book>> addBkToStudent(@RequestBody Book book, @PathVariable Long id) {
        return addBookToStudent(book, id);
    }

    //    Remove book from student book list
    @RequestMapping(value = "/students/{id}/books", method = RequestMethod.DELETE)
    public ResponseEntity<List<Book>> removeBkFromStudent(@RequestBody Book book, @PathVariable Long id) {
        return removeStudentBook(book, id);
    }

}