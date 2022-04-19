package quan_ly_thu_vien.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String name;
    private String mssv;
    private String id_card;
    private String address;
    private String className;
    private String email;
    private String phone;
    @JsonBackReference
    @OneToMany(mappedBy = "student")
    private List<BookStudent> bookStudentList;

    public Student(Integer student_id, String name, String mssv, String id_card, String address, String className, String email, String phone, List<BookStudent> bookStudentList) {
        this.student_id = student_id;
        this.name = name;
        this.mssv = mssv;
        this.id_card = id_card;
        this.address = address;
        this.className = className;
        this.email = email;
        this.phone = phone;
        this.bookStudentList = bookStudentList;
    }

    public Student() {
    }

    public List<BookStudent> getBookStudentList() {
        return bookStudentList;
    }

    public void setBookStudentList(List<BookStudent> bookStudentList) {
        this.bookStudentList = bookStudentList;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
