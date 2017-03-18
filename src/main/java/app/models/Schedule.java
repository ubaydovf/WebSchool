package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class Schedule implements Serializable {

    /** Fields */
    @Id
    private Long id;
    private List<Clazz> clazzes;
    private Map<Clazz, List<List<Byte>>> marks;

    /** Constructors */
    public Schedule() {
    }

    /** Methods */
    public void addClass(Clazz clazz){
        clazzes.add(clazz);
    }

    public void removeClass(Clazz clazz){
        clazzes.remove(clazz);
    }

    /** Getter and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public Map<Clazz, List<List<Byte>>> getMarks() {
        return marks;
    }

    public void setMarks(Map<Clazz, List<List<Byte>>> marks) {
        this.marks = marks;
    }
}
