package quan_ly_thu_vien.demo.service;

import quan_ly_thu_vien.demo.model.Equipment;

import java.util.List;

public interface IEquimentService {
    List<Equipment> findAll();

    void updateStatusT(Integer temperature);

    void updateStatusH(Integer humidity);

    void updateStatusG(Integer gas);

    void updateStatusL(Integer lamp);

    void updateStatusF(Integer fan);
}
