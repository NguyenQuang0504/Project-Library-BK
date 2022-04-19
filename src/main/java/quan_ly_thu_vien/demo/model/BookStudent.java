package quan_ly_thu_vien.demo.model;

import javax.persistence.*;

@Entity
public class BookStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBookStudent;
    private String dateStart;
    private String dateEnd;

    public BookStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public BookStudent(Integer idBookStudent, String dateStart, String dateEnd, Student student, Book book) {
        this.idBookStudent = idBookStudent;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.student = student;
        this.book = book;
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
