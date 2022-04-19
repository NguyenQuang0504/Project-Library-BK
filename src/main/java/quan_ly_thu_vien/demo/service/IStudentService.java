package quan_ly_thu_vien.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quan_ly_thu_vien.demo.model.Student;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    List<Student> findAll();

    String getNameStudent(Integer id);

    List<Student> findByName(String name);

    Student findById(Integer id);
}
