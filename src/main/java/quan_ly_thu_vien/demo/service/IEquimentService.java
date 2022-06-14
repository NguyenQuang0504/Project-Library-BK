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

    String findStatusLamp1();

    void save(List<Equipment> equipment);

    List<Equipment> getDevice();

    void updateStatusL2(Integer status);

    void updateStatusF2(Integer status);
}
