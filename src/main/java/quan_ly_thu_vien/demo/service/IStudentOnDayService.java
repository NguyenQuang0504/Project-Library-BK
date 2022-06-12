package quan_ly_thu_vien.demo.service;

import quan_ly_thu_vien.demo.model.StudentOnDay;
import quan_ly_thu_vien.demo.repository.IStudentOnDay;

import java.util.List;

public interface IStudentOnDayService {
    void save(StudentOnDay studentOnDay);

    List<StudentOnDay> findAll();
}
