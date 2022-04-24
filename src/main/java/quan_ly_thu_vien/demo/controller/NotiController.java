package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import quan_ly_thu_vien.demo.model.BookStudent;
import quan_ly_thu_vien.demo.model.Notification;
import quan_ly_thu_vien.demo.service.IBookService;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.INotifiService;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/notification")
public class NotiController {
    @Autowired
    private INotifiService notifiService;
    @GetMapping("/display")
    public String display(@PageableDefault(size = 5) Pageable pageable, ModelMap modelMap) {
        Page<Notification> notificationList = notifiService.findAll(pageable);
        modelMap.addAttribute("list", notificationList);
        return "notification/home";
    }
    @GetMapping("/{id}")
    public String deleteNotifi(@PathVariable Integer id){
        notifiService.delete(id);
        return "redirect:/notification/display";
    }
}
