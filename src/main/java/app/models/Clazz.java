package app.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clazz implements Serializable {

    /** Clazz fields*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer id_n;
    private Character id_c;
    private String language;

    @OneToMany
    private List<Student> students = new ArrayList<>();

    private Long classTeacher;

    @OneToOne
    private Student captain;

    @OneToOne
    private Schedule schedule;

    @OneToOne
    private Awards awards;

    /** Constructors */
    public Clazz() {
    }

    public Clazz(Integer id_n, Character id_c, String language) {
        this.id_n = id_n;
        this.id_c = id_c;
        this.language = language;
    }

    /** Methods */

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    /** Getters and Setters */
    public Long getId() {
        return id;
    }

    public Integer getId_n() {
        return id_n;
    }

    public void setId_n(Integer id_n) {
        this.id_n = id_n;
    }

    public Character getId_c() {
        return id_c;
    }

    public void setId_c(Character id_c) {
        this.id_c = id_c;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Long classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Student getCaptain() {
        return captain;
    }

    public void setCaptain(Student captain) {
        this.captain = captain;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }
}
