package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.model.Student;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IBookStudentService iBookStudentService;

    @Autowired
    private IStudentService iStudentService;
    @GetMapping("/home")
    public String display(@PageableDefault(size = 7)Pageable pageable, ModelMap modelMap){
        Page<Student> listStudent = iStudentService.findAll(pageable);
        modelMap.addAttribute("listStudent", listStudent);
        return "student/list";
    }
    @PostMapping("/saveBook/{id}")
    public String saveBook(@ModelAttribute BookStudent bookStudent, @PathVariable Integer id){
        bookStudent.setStudent(iStudentService.findById(id));
        iBookStudentService.save(bookStudent);
        return "redirect:/student/home";
    }
}
