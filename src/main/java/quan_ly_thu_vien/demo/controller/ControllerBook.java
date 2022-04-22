package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.model.CategoryBook;
import quan_ly_thu_vien.demo.model.Student;
import quan_ly_thu_vien.demo.service.IBookService;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.ICategoryBookService;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/book")
public class ControllerBook {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICategoryBookService iCategoryBookService;
    @Autowired
    private IBookStudentService iBookStudentService;
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/create")
    public String createBook(ModelMap modelMap) {
        List<CategoryBook> categoryBookList = iCategoryBookService.findAll();
        modelMap.addAttribute("listCategory", categoryBookList);
        modelMap.addAttribute("listBook", new Book());
        return "book/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute(name = "listBook") Book listBook1, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasFieldErrors()) {
            List<CategoryBook> categoryBookList = iCategoryBookService.findAll();
            modelMap.addAttribute("listCategory", categoryBookList);
            return "book/create";
        }
        iBookService.save(listBook1);
        return "redirect:/book/display";
    }

    @GetMapping("/display")
    public ModelAndView getListCategory(@PageableDefault(size = 7) Pageable pageable) {
        Page<CategoryBook> list = iCategoryBookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("book/home", "listCategory", list);
        return modelAndView;
    }

    @GetMapping("/category/{id}")
    public ModelAndView getListBook(@PageableDefault(size = 7) Pageable pageable, @PathVariable Integer id, ModelMap modelMap) {
        Page<Book> listBook = iBookService.findByIdCategory(id, pageable);
        modelMap.addAttribute("id", id);
        ModelAndView modelAndView = new ModelAndView("book/listBook", "listBook", listBook);
        return modelAndView;
    }

    @GetMapping("/getBook/{id}")
    public ModelAndView getBook(@PathVariable Integer id, ModelMap modelMap) {
        Student student = iStudentService.findById(id);
        modelMap.addAttribute("student1", student);
        List<Book> bookList = iBookService.findAllBook();
        // Chuyen mac dinh sang mm/dd/yyy
        LocalDate dateStart = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = dateStart.format(formatters);
        // Cong ngay bat dau them 30 day de add vao ngay phai tra
        LocalDate dateEnd = dateStart.plusDays(30);
        DateTimeFormatter formatters1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text1 = dateEnd.format(formatters1);
        modelMap.addAttribute("listBook", bookList);
        modelMap.addAttribute("id", id);
        // Tao bookStudent voi ngay muon la ngay hien tai, ngay tra la ngay mac dinh 1 thang
        BookStudent bookStudent = new BookStudent(text, text1);
        return new ModelAndView("student/getBook", "bookStudent", bookStudent);
    }

    @GetMapping("/return/{id}/{idBook}/{idStudent}")
    public String returnBook(@PathVariable Integer id, @PathVariable Integer idBook, @PathVariable Integer idStudent) {
        iBookStudentService.delete(id);
        iBookService.returnBook(idBook);
        return "redirect:/book/show/" + idStudent;
    }

    @GetMapping("/addBook")
    public String addBook(ModelMap modelMap) {
        List<Book> listBook = iBookService.findAll();
        modelMap.addAttribute("listBook", listBook);
        return "book/addBook";
    }

    @PostMapping("/add")
    public String add(@RequestParam Integer numBook, @RequestParam Integer book) {
        iBookService.addBook(book, numBook);
        return "redirect:/book/display";
    }
}
