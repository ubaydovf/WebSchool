package app.interfaces;

import app.models.Subject;

import java.util.List;

public interface SubjectService {

    Subject addSubject(Subject subject);

    Subject getSubjectById(Long id);

    List<Subject> getSubjects();

    Subject updateSubject(Subject subject);

    void deleteSubjectById(Long id);
}
