package quan_ly_thu_vien.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quan_ly_thu_vien.demo.model.Notification;

import java.util.List;

public interface INotifiService {
    void setValue(Integer integer);

    List<Integer> findAllId();

    Page<Notification> findAll(Pageable pageable);

    void delete(Integer id);
}
