package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.Notification;
import quan_ly_thu_vien.demo.repository.INotifiRepository;
import quan_ly_thu_vien.demo.service.INotifiService;

import java.util.List;

@Service
public class NotifiService implements INotifiService {
    @Autowired
    private INotifiRepository iNotifiRepository;

    @Override
    public void setValue(Integer integer) {
        iNotifiRepository.setValue(integer);
    }

    @Override
    public List<Integer> findAllId() {
        return iNotifiRepository.findAllId();
    }

    @Override
    public Page<Notification> findAll(Pageable pageable) {
        return iNotifiRepository.findAll(pageable);
    }
}
