package quan_ly_thu_vien.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import quan_ly_thu_vien.demo.model.Equipment;

import java.util.List;

@Repository
@Transactional
public interface IEquimentRepository extends JpaRepository<Equipment, Integer> {

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 1;", nativeQuery = true)
    void updateStatusT(Integer temperature);

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 2;", nativeQuery = true)
    void updateStatusH(Integer humidity);

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 3;", nativeQuery = true)
    void updateStatusG(Integer gas);

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 4;", nativeQuery = true)
    void updateStatusL(Integer lamp);

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 5;", nativeQuery = true)
    void updateStatusF(Integer fan);

    @Query(value = "select status from equipment where id = 4;", nativeQuery = true)
    String findStatusLamp1();

    @Query(value = "select * from equipment where id = 4 or id = 5 or id = 9 or id = 10", nativeQuery = true)
    List<Equipment> getDevice();

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 9;", nativeQuery = true)
    void updateStatusL2(Integer status);

    @Modifying
    @Query(value = "update equipment set status = ?1 where id = 10;", nativeQuery = true)
    void updateStatusF2(Integer status);
}
