package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.StudentId;
import quan_ly_thu_vien.demo.repository.IStudentIdRepository;
import quan_ly_thu_vien.demo.service.IStudentId;

import java.util.List;

@Service
public class StudentIdService implements IStudentId {
    @Autowired
    private IStudentIdRepository iStudentIdRepository;

    @Override
    public void save(StudentId student) {
        iStudentIdRepository.save(student);
    }

    @Override
    public List<StudentId> findAll() {
        return iStudentIdRepository.findAll();
    }
}
