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

}
