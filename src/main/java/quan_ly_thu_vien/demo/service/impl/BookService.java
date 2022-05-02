package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.repository.IBookRepository;
import quan_ly_thu_vien.demo.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Page<Book> findByIdCategory(Integer id, Pageable pageable) {
        return iBookRepository.findByIdCategory(id, pageable);
    }

    @Override
    public List<Book> search1(String search) {
        return iBookRepository.search1(search);
    }

    @Override
    public void save(Book listBook) {
        iBookRepository.save(listBook);
    }

    @Override
    public void setNumBook(Integer book_id) {
        iBookRepository.setNumBook(book_id);
    }

    @Override
    public int getNumBook(Integer book_id) {
        return iBookRepository.getNumBook(book_id);
    }

    @Override
    public void delete(Integer book_id) {
        iBookRepository.deleteById(book_id);
    }

    @Override
    public List<Book> findAllBook() {
        return iBookRepository.findAllBook();
    }

    @Override
    public void returnBook(Integer idBook) {
        iBookRepository.returnBook(idBook);
    }

    @Override
    public void addBook(Integer book, Integer numBook) {
        iBookRepository.addBook(book, numBook);
    }

    @Override
    public Page<Book> findByWarning(Pageable pageable) {
        return iBookRepository.findByWarning(pageable);
    }

}
