package app.services;

import app.interfaces.ClazzService;
import app.interfaces.TeacherService;
import app.models.Clazz;
import app.models.Teacher;
import app.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClazzService clazzService;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.delete(id);
    }

    @Override
    public Teacher findTeacherByClazzesId(Long clazzesId) {
        Clazz clazz = clazzService.getClazzById(clazzesId);
        if (clazz != null) {
            if (clazz.getTeacherId() != null) {
                return teacherRepository.findOne(clazz.getTeacherId());
            }
        }
        return null;
    }
}
