package quan_ly_thu_vien.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookStudent_id", referencedColumnName = "idBookStudent")
    @JsonBackReference
    private BookStudent bookStudent;

    public Notification(Integer id, BookStudent bookStudent) {
        this.id = id;
        this.bookStudent = bookStudent;
    }

    public Notification() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookStudent getBookStudent() {
        return bookStudent;
    }

    public void setBookStudent(BookStudent bookStudent) {
        this.bookStudent = bookStudent;
    }
}
