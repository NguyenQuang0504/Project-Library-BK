package quan_ly_thu_vien.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quan_ly_thu_vien.demo.model.CategoryBook;
@Repository
public interface ICategoryRepository extends JpaRepository<CategoryBook, Integer> {
    Page<CategoryBook> findAll(Pageable pageable);
}
