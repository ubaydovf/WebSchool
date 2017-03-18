package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Teacher implements Serializable {

    /** Fields */
    @Id
    private Long id;
    private String name;
    private String sureName;
    private String lastName;
    private List<Subject> subjects;
    private Schedule schedule;
    private List<Clazz> clazzes;
    private Awards award;

    /** Constructors */
    public Teacher() {
    }

    public Teacher(String name, String sureName, String lastName) {
        this.name = name;
        this.sureName = sureName;
        this.lastName = lastName;
    }

    /** Methods */
    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }
    public void addClass(Clazz clazz){
        clazzes.add(clazz);
    }

    public void removeClass(Clazz clazz){
        clazzes.remove(clazz);
    }

    /** Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public Awards getAward() {
        return award;
    }

    public void setAward(Awards award) {
        this.award = award;
    }
}
