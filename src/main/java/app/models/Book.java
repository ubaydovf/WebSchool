package app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book implements Serializable {

    /** Fields  */
    @Id
    private Long id;
    private String name;
    private String authors;
    private String dateOfCreation;
    private List<Student> holders;
    private static int count = 0;


    /** Constructors  */
    public Book() {
        holders = new ArrayList<>();
    }

    public Book(String name, String authors, String date) {
        this.name = name;
        this.authors = authors;
        this.dateOfCreation = date;
        holders = new ArrayList<>();
    }

    /** Methods */
    public void addHolder(Student student){
        holders.add(student);
    }

    public void removeHolder(Student student){
        holders.remove(student);
    }

    /** Setter and Getters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Student> getHolders() {
        return holders;
    }

    public void setHolders(List<Student> holders) {
        this.holders = holders;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }
}
