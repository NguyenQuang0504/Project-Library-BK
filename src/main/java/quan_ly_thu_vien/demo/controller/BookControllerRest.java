package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.service.IBookService;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.ICategoryBookService;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookControllerRest {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICategoryBookService iCategoryBookService;
    @Autowired
    private IBookStudentService iBookStudentService;
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByName(String Search1){
        List<Book> listBook = iBookService.search1(Search1);
        return new ResponseEntity<>(listBook, HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ModelAndView showBook(@PageableDefault(size = 7)Pageable pageable,@PathVariable Integer id, ModelMap modelMap){
        Page<BookStudent> list = iBookStudentService.findAllById(id, pageable);
        String name = iStudentService.getNameStudent(id);
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("id", id);
        return new ModelAndView("student/listBook", "listBook", list);
    }
//    @GetMapping("/return/{id}")
//    public ResponseEntity<List<BookStudent>> display(@PathVariable Integer id){
//
//    }
}
