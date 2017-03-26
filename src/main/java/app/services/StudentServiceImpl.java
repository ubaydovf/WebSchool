package app.services;

import app.interfaces.StudentService;
import app.models.Student;
import app.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findOne(id);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.delete(id);
    }

    @Override
    public List<Student> findStudentByClazzId(Long selfClazzId) {
        return studentRepository.findStudentByClazzId(selfClazzId);
    }

}
