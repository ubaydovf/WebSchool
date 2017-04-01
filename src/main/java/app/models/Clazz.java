package app.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Clazz implements Serializable {

    /** Clazz fields*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer id_n;
    private Character id_c;
    private String language;

    private Long classTeacher;

    private Long captainId;

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

    public Long getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Long classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Long getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Long captainId) {
        this.captainId = captainId;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }
}
