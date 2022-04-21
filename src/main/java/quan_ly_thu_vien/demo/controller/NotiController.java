package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.service.IBookService;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/notification")
public class NotiController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookStudentService iBookStudentService;

    @GetMapping("/display")
    public String display(@PageableDefault(size = 6) Pageable pageable, ModelMap modelMap) {
        Page<BookStudent> list = iBookStudentService.findAll(pageable);
        modelMap.addAttribute("list", list);
        return "notification/home";
    }

}
