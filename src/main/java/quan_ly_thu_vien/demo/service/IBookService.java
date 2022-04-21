package quan_ly_thu_vien.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quan_ly_thu_vien.demo.model.Book;

import java.util.List;

public interface IBookService  {
    List<Book> findAll();

    Page<Book> findByIdCategory(Integer id, Pageable pageable);

    List<Book> search1(String search);

    void save(Book listBook);

    void setNumBook(Integer book_id);

    int getNumBook(Integer book_id);

    void delete(Integer book_id);

    List<Book> findAllBook();

    void returnBook(Integer idBook);

    void addBook(Integer book, Integer numBook);
}
