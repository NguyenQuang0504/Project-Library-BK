package quan_ly_thu_vien.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quan_ly_thu_vien.demo.model.StudentOnDay;
@Repository
public interface IStudentOnDay extends JpaRepository<StudentOnDay, Integer> {
}
