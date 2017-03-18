package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Student implements Serializable {

    /** Student Fields  */
    @Id
    private Long id;
    private String name;
    private String sureName;
    private String lastName;
    private Integer age;
    private Date dateOfBirth;
    private Boolean sex;
    private String address;
    private String nation;
    private Clazz selfClazz;
    private Marks marks;
    private List<Book> books;
    private Schedule schedule;
    private Awards awards;
    private Boolean isCaptain;

    /** Constructors */
    public Student() {
    }

    public Student(String name, String sureName, String lastName,
                    Integer age, Date dateOfBirth, Boolean sex,
                        String address, String nation, Clazz selfClazz) {
        this.name = name;
        this.sureName = sureName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.nation = nation;
        this.selfClazz = selfClazz;
        this.marks = marks;
        this.books = books;
        this.schedule = schedule;
        this.awards = awards;
        this.isCaptain = isCaptain;
    }

    /** Methods */
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    /** Setter and Getters */
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Clazz getSelfClazz() {
        return selfClazz;
    }

    public void setSelfClazz(Clazz selfClazz) {
        this.selfClazz = selfClazz;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }
}
