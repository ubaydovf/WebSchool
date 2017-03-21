package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Marks implements Serializable {

    /** Fields */
    @Id
    private Long id;
//    private List<Subject> subjects;
//    private Map<Subject, List<Integer>> subjectMarks;

    /** Constructors */
    public Marks() {
    }

    /** Methods */
//    public void addSubject(Subject subject){
//        subjects.add(subject);
//    }
//    public void removeSubject(Subject subject){
//        subjects.remove(subject);
//    }

    /** Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Subject> getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(List<Subject> subjects) {
//        this.subjects = subjects;
//    }
//
//    public Map<Subject, List<Integer>> getSubjectMarks() {
//        return subjectMarks;
//    }
//
//    public void setSubjectMarks(Map<Subject, List<Integer>> subjectMarks) {
//        this.subjectMarks = subjectMarks;
//    }
}
