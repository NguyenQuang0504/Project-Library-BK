package quan_ly_thu_vien.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.model.CategoryBook;
import quan_ly_thu_vien.demo.repository.ICategoryRepository;
import quan_ly_thu_vien.demo.service.ICategoryBookService;

import java.util.List;

@Service
public class CategoryBookService implements ICategoryBookService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public Page<CategoryBook> findAll(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public List<CategoryBook> findAll() {
        return iCategoryRepository.findAll();
    }

}
