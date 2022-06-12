package quan_ly_thu_vien.demo.service;

import quan_ly_thu_vien.demo.model.StudentId;

import java.util.List;

public interface IStudentId {
    void save(StudentId student);

    List<StudentId> findAll();
}
