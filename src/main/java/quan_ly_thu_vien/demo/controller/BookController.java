package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.model.CategoryBook;
import quan_ly_thu_vien.demo.service.IBookService;
import quan_ly_thu_vien.demo.service.ICategoryBookService;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICategoryBookService iCategoryBookService;
    @GetMapping("/display")
        public ModelAndView getListCategory(@PageableDefault(size = 7) Pageable pageable){
        Page<CategoryBook> list = iCategoryBookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("book/home", "listCategory", list);
        return modelAndView;
    }
    @GetMapping("/category/{id}")
    public ModelAndView getListBook(@PageableDefault(size = 7) Pageable pageable, @PathVariable Integer id, ModelMap modelMap){
        Page<Book> listBook = iBookService.findByIdCategory(id, pageable);
        modelMap.addAttribute("id", id);
        ModelAndView modelAndView = new  ModelAndView("book/listBook", "listBook", listBook);
        return modelAndView;
    }
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByName(String Search1){
        List<Book> listBook = iBookService.search1(Search1);
        return new ResponseEntity<>(listBook, HttpStatus.OK);
    }
    @GetMapping("/create")
    public ModelAndView createBook( ModelMap modelMap){
        List<CategoryBook> categoryBookList = iCategoryBookService.findAll();
        modelMap.addAttribute("listCategory", categoryBookList);
        return new ModelAndView("book/create","listBook", new Book());
    }
    @PostMapping("/save")
    public ModelAndView save(@PageableDefault(size = 7) Pageable pageable,@ModelAttribute Book listBook, ModelMap modelMap){
        iBookService.save(listBook);
        String mess = "Thêm thành công";
        modelMap.addAttribute("mess",mess);
        Page<CategoryBook> list = iCategoryBookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("book/home", "listCategory", list);
        return modelAndView;
    }
}
