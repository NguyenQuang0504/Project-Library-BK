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
import quan_ly_thu_vien.demo.model.Book;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.model.Student;
import quan_ly_thu_vien.demo.service.IBookService;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IBookStudentService iBookStudentService;

    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IBookService iBookService;
    @GetMapping("/home")
    public String display(@PageableDefault(size = 7)Pageable pageable, ModelMap modelMap){
        Page<Student> listStudent = iStudentService.findAll(pageable);
        modelMap.addAttribute("listStudent", listStudent);
        return "student/list";
    }
    @PostMapping("/saveBook/{id}")
    public String saveBook(@Validated @ModelAttribute BookStudent bookStudent, BindingResult bindingResult, @PathVariable Integer id, ModelMap modelMap){
        if (bindingResult.hasFieldErrors()){
            Student student = iStudentService.findById(id);
            modelMap.addAttribute("student1", student);
            List<Book> bookList = iBookService.findAll();
            modelMap.addAttribute("listBook", bookList);
            modelMap.addAttribute("id", id);
            return "student/getBook";
        }
        bookStudent.setStudent(iStudentService.findById(id));
        iBookStudentService.save(bookStudent);
        iBookService.setNumBook(bookStudent.getBook().getBook_id());
        return "redirect:/student/home";
    }
    @GetMapping("/listWarning")
    public String listWarning(@PageableDefault(size = 7)Pageable pageable, ModelMap modelMap){
        LocalDate dateStart = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = dateStart.format(formatters);
        Page<BookStudent> listStudent = iBookStudentService.findWarning(text, pageable);
        modelMap.addAttribute("list", listStudent);
        return "student/warning";
    }
}
