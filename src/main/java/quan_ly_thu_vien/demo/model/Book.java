package quan_ly_thu_vien.demo.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer numBook;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryBook category;
    
    public String getAuthor() {
        return author;
    }

    public Book(Integer id, String name, String author, Integer numBook, CategoryBook category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.numBook = numBook;
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Book(CategoryBook category) {
        this.category = category;
    }

    public CategoryBook getCategory() {
        return category;
    }

    public void setCategory(CategoryBook category) {
        this.category = category;
    }

    public Book(Integer id, String name, Integer numBook) {
        this.id = id;
        this.name = name;
        this.numBook = numBook;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumBook() {
        return numBook;
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
