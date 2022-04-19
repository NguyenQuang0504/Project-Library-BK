package quan_ly_thu_vien.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    @NotEmpty(message = "Khong duoc de trong")
    @Size(min = 1, max = 255, message = "Do dai khong phu hop")
    private String name;
    @NotEmpty(message = "Khong duoc de trong")
    private String author;
    @NotNull(message = "Khong duoc de trong")
    private Integer numBook;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public List<BookStudent> getBookStudentList() {
        return bookStudentList;
    }

    public void setBookStudentList(List<BookStudent> bookStudentList) {
        this.bookStudentList = bookStudentList;
    }

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryBook category;

   @OneToMany(mappedBy = "book")
   @JsonBackReference
   private List<BookStudent> bookStudentList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumBook() {
        return numBook;
    }

    public CategoryBook getCategory() {
        return category;
    }

    public void setCategory(CategoryBook category) {
        this.category = category;
    }

    public Book(Integer book_id, String name, String author, Integer numBook, CategoryBook category, List<BookStudent> bookStudentList) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.numBook = numBook;
        this.category = category;
        this.bookStudentList = bookStudentList;
    }

    public Book(CategoryBook category) {
        this.category = category;
    }



    public Book(Integer id, String name, Integer numBook) {
        this.book_id = id;
        this.name = name;
        this.numBook = numBook;
    }

    public Book() {
    }



    public void setNumBook(Integer numBook) {
        this.numBook = numBook;
    }
    public Integer addBook(Integer number){
       return this.numBook = this.numBook+number;
    }
    public Integer subBook(Integer number){
        return this.numBook = this.numBook-number;
    }
}
