package quan_ly_thu_vien.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import quan_ly_thu_vien.demo.model.Book;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book where category_id = ?1", countQuery = "select count(*) from book where category_id = ?1", nativeQuery = true)
    Page<Book> findByIdCategory(Integer id, Pageable pageable);

    @Query(value = "select * from book where book.name like %?1% " ,countQuery = "select count(*) from book where book.name like %?1%", nativeQuery = true)
    List<Book> search1(String search);
}
