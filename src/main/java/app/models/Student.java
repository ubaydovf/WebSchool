package app.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student implements Serializable {

    /** Student Fields  */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sureName;
    private String lastName;
    private Integer age;        /** Возраст должен автоматом считаться при вводе Дня Рождения, ИСПРАВИТЬ !*/
    private Date dateOfBirth;   /** Нужно вводить дату понятную человеком, а не в миллисекундах, ИСПРАВИТЬ !*/
    private Boolean sex;        /** Что за дискриминация? а если человек не определился с выбором ПОЛА ?! */
    private String address;
    private String nation;
    private Long clazzId;
    private Long marksId;

    @ManyToMany
    private List<Book> books = new ArrayList<>();

    @OneToOne
    private Awards awards;
    private Boolean isCaptain;

    /** Constructors */
    public Student() {
    }

    public Student(String name, String sureName, String lastName,
                   Integer age, Date dateOfBirth, Boolean sex,
                   String address, String nation) {
        this.name = name;
        this.sureName = sureName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.nation = nation;
        this.books = books;
        this.awards = awards;
        this.isCaptain = isCaptain;
    }

    public Student(String name, String sureName, String lastName,
                   Integer age, Date dateOfBirth, Boolean sex,
                   String address, String nation, Long classId) {
        this.name = name;
        this.sureName = sureName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
        this.nation = nation;
        this.clazzId = classId;
        this.books = books;
        this.awards = awards;
        this.isCaptain = isCaptain;
    }

    /** Methods */
    public void addBook(Book bookId){
        books.add(bookId);
    }
    public void removeBook(Book bookId){
        books.remove(bookId);
    }

    /** Setter and Getters */

    public Long getId() {
        return id;
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

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public Long getMarksId() {
        return marksId;
    }

    public void setMarksId(Long marksId) {
        this.marksId = marksId;
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

    public Long getSelfClazz() {
        return clazzId;
    }

    public void setSelfClazz(Long classId) {
        this.clazzId = classId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
