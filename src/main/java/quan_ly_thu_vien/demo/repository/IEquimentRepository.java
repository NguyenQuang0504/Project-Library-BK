package quan_ly_thu_vien.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import quan_ly_thu_vien.demo.model.Equipment;

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
}
