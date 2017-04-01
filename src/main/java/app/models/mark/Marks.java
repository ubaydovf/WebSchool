package app.models.mark;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Marks implements Serializable {

    /** Fields */
    @Id
    private Long id;

//    @ManyToMany
//    private Map<Subject, Map<String, String>> subjectMarks;

    /** Constructors */
    public Marks() {
    }

    /** Methods */

    /** Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Map<Subject, List<Integer>> getSubjectMarks() {
//        return subjectMarks;
//    }
//
//    public void setSubjectMarks(Map<Subject, List<Integer>> subjectMarks) {
//        this.subjectMarks = subjectMarks;
//    }
}
