package quan_ly_thu_vien.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentOnDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String idCard;
    private String name;
    private String date;
    private String className;
    private String email;
    private String dateIn;
    private String DateOut;

    public StudentOnDay(Integer id, String idCard, String name, String date, String className, String email, String dateIn, String dateOut) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.date = date;
        this.className = className;
        this.email = email;
        this.dateIn = dateIn;
        DateOut = dateOut;
    }

    public StudentOnDay(Integer id, String idCard, String name, String date, String className, String email) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.date = date;
        this.className = className;
        this.email = email;
    }

    public StudentOnDay() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return DateOut;
    }

    public void setDateOut(String dateOut) {
        DateOut = dateOut;
    }
}
