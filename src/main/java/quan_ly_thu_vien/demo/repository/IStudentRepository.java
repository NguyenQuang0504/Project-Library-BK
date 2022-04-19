package quan_ly_thu_vien.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quan_ly_thu_vien.demo.model.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findAll(Pageable pageable);
    @Query(value = "select `name` from student where student_id =?1", nativeQuery = true)
    String findName(Integer id);
    @Query(value = "select * from student where `name` like %?1%", nativeQuery = true)
    List<Student> findByName(String name);
}
