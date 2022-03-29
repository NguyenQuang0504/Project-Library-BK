package quan_ly_thu_vien.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.model.CategoryBook;

import java.util.List;

public interface ICategoryBookService {
    Page<CategoryBook> findAll(Pageable pageable);
    List<CategoryBook> findAll();
}
