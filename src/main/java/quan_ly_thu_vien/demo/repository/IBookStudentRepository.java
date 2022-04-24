package quan_ly_thu_vien.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.model.Student;

import java.util.List;

@Repository
public interface IBookStudentRepository extends JpaRepository<BookStudent, Integer> {
    @Query(value = "select * from bookstudent where student_id = ?1", nativeQuery = true)
    Page<BookStudent> findAllById(Integer id, Pageable pageable);
    @Query(value = "select student.name from bookstudent inner join student on student.student_id=bookstudent.student_id where student.student_id=?1 group by student.student_id", nativeQuery = true)
    String findName(Integer id);
    @Query(value = "select idBookStudent from bookstudent where dateEnd >= ?1", nativeQuery = true)
    List<Integer> findIdByDate(String text);
    @Query(value = "select * from bookstudent where dateEnd >= ?1 group by student_id", nativeQuery = true)
    Page<BookStudent> findWarning(String text, Pageable pageable);

    @Query(value = "select * from bookstudent where dateEnd >= ?1 and student_id=?2", nativeQuery = true)
    Page<BookStudent> findByIdStudent(String text,Integer id, Pageable pageable);
    @Query(value = "select name from bookstudent inner join student on bookstudent.student_id = ?1 = student.student_id group by student.student_id;", nativeQuery = true)
    String findStudent(Integer id);
}
