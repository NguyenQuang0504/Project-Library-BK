package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.Equipment;
import quan_ly_thu_vien.demo.repository.IEquimentRepository;
import quan_ly_thu_vien.demo.service.IEquimentService;

import java.util.List;

@Service
public class EquimentService implements IEquimentService {
    @Autowired
    private IEquimentRepository iEquimentRepository;

    @Override
    public List<Equipment> findAll() {
        return iEquimentRepository.findAll();
    }

    @Override
    public void updateStatusT(Integer temperature) {
        iEquimentRepository.updateStatusT(temperature);
    }

    @Override
    public void updateStatusH(Integer humidity) {
        iEquimentRepository.updateStatusH(humidity);
    }

    @Override
    public void updateStatusG(Integer gas) {
    iEquimentRepository.updateStatusG(gas);
    }

    @Override
    public void updateStatusL(Integer lamp) {
    iEquimentRepository.updateStatusL(lamp);
    }

    @Override
    public void updateStatusF(Integer fan) {
    iEquimentRepository.updateStatusF(fan);
    }

    @Override
    public String findStatusLamp1() {
        return iEquimentRepository.findStatusLamp1();
    }
}
