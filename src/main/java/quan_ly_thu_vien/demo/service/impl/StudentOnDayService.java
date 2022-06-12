package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.StudentOnDay;
import quan_ly_thu_vien.demo.repository.IStudentOnDay;
import quan_ly_thu_vien.demo.service.IStudentOnDayService;

import java.util.List;

@Service
public class StudentOnDayService implements IStudentOnDayService {
    @Autowired
    private IStudentOnDay iStudentOnDay;

    @Override
    public void save(StudentOnDay studentOnDay) {
        iStudentOnDay.save(studentOnDay);
    }

    @Override
    public List<StudentOnDay> findAll() {
        return iStudentOnDay.findAll();
    }
}
