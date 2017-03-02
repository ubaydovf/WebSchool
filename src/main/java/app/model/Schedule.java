package app.model;

import java.util.List;
import java.util.Map;

public class Schedule {

    /** Fields */
    private Long id;
    private List<Class> classes;
    private Map<Class, List<List<Byte>>> marks;

    /** Constructors */
    public Schedule() {
    }

    /** Methods */
    public void addClass(Class clazz){
        classes.add(clazz);
    }

    public void removeClass(Class clazz){
        classes.remove(clazz);
    }

    /** Getter and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public Map<Class, List<List<Byte>>> getMarks() {
        return marks;
    }

    public void setMarks(Map<Class, List<List<Byte>>> marks) {
        this.marks = marks;
    }
}
