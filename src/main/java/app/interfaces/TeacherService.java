package app.interfaces;

import app.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher subject);

    Teacher getTeacherById(Long id);

    List<Teacher> getTeachers();

    Teacher updateTeacher(Teacher subject);

    void deleteTeacherById(Long id);

    Teacher findTeacherByClazzesId(Long clazzesId);

}
