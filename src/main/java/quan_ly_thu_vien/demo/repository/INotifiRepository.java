package quan_ly_thu_vien.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import quan_ly_thu_vien.demo.model.Notification;

import java.util.List;

@Repository
public interface INotifiRepository extends JpaRepository<Notification, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into notification(bookStudent_id) values(?1)", nativeQuery = true)
    void setValue(Integer integer);
    @Query(value = "select bookStudent_id from notification", nativeQuery = true)
    List<Integer> findAllId();
}
