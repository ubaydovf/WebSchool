package app.interfaces;

import app.models.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getStudents();

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
