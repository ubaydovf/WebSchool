package app.models;

import app.models.schedule.ScheduleWeek;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Teacher implements Serializable {

    /** Fields */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sureName;
    private String lastName;
    private Date dateOfBirth;
    private Integer age;

    @ManyToMany
    private List<Subject> subjects;

    @OneToOne
    private ScheduleWeek scheduleWeek;

    @OneToMany
    private List<Clazz> clazzes;

    @OneToOne
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public ScheduleWeek getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(ScheduleWeek scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
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
