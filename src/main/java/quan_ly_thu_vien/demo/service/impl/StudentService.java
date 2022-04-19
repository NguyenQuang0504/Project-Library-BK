package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.Student;
import quan_ly_thu_vien.demo.repository.IStudentRepository;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public String getNameStudent(Integer id) {
        return iStudentRepository.findName(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return iStudentRepository.findByName(name);
    }

    @Override
    public Student findById(Integer id) {
        return iStudentRepository.findById(id).orElse(null);
    }
}
