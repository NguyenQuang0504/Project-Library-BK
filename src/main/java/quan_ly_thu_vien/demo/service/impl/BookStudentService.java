package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.repository.IBookStudentRepository;
import quan_ly_thu_vien.demo.service.IBookStudentService;

import java.util.List;

@Service
public class BookStudentService implements IBookStudentService {
    @Autowired
    private IBookStudentRepository iBookStudentRepository;

    @Override
    public Page<BookStudent> findAllById(Integer id, Pageable pageable) {
        return iBookStudentRepository.findAllById(id, pageable);
    }

    @Override
    public String getNameStudent(Integer id) {
        return iBookStudentRepository.findName(id);
    }

    @Override
    public void save(BookStudent bookStudent) {
        iBookStudentRepository.save(bookStudent);
    }

    @Override
    public void delete(Integer id) {
        iBookStudentRepository.deleteById(id);
    }

    @Override
    public Page<BookStudent> findAll(Pageable pageable) {
       return iBookStudentRepository.findAll(pageable);
    }
}
