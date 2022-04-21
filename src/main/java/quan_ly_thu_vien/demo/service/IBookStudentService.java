package quan_ly_thu_vien.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quan_ly_thu_vien.demo.model.BookStudent;

import java.util.List;

public interface IBookStudentService {
    Page<BookStudent> findAllById(Integer id, Pageable pageable);

    String getNameStudent(Integer id);

    void save(BookStudent bookStudent);

    void delete(Integer id);

    Page<BookStudent> findAll(Pageable pageable);
}
