package quan_ly_thu_vien.demo.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class BookStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBookStudent;
    @NotEmpty(message = "Vui long chon ngay bat dau")
    private String dateStart;
    @NotEmpty(message = "Vui long chon ngay tra sach")
    private String dateEnd;

    public BookStudent(Student student) {
        this.student = student;
    }

    public BookStudent(@NotEmpty(message = "Vui long chon ngay bat dau") String dateStart) {
        this.dateStart = dateStart;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne(mappedBy = "bookStudent")
    private Notification notification;

    public BookStudent(Integer idBookStudent, String dateStart, String dateEnd, Student student, Book book) {
        this.idBookStudent = idBookStudent;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.student = student;
        this.book = book;
    }

    public BookStudent(@NotEmpty(message = "Vui long chon ngay bat dau") String dateStart, @NotEmpty(message = "Vui long chon ngay tra sach") String dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public BookStudent() {
    }

    public Integer getIdBookStudent() {
        return idBookStudent;
    }

    public void setIdBookStudent(Integer idBookStudent) {
        this.idBookStudent = idBookStudent;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
