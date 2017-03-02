package app.model;

import java.util.List;

public class Class {

    /** Class fields*/
    private Long id;
    private Integer id_n;
    private Character id_c;
    private String language;
    private List<Student> students;
    private Teacher classTeacher;
    private Student captain;
    private Schedule schedule;
    private Awards awards;

    /** Constructors */
    public Class() {
    }

    public Class(Integer id_n, Character id_c, String language) {
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

    public void setId(Long id) {
        this.id = id;
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

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
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
