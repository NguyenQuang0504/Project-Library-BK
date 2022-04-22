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
    private IStudentService iStudentService;
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookStudentService iBookStudentService;
    @Autowired
    private INotifiService notifiService;
    @GetMapping("/display")
    public String display(@PageableDefault(size = 6) Pageable pageable, ModelMap modelMap) {
        // Chuyen mac dinh sang mm/dd/yyy
        LocalDate dateStart = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = dateStart.format(formatters);
        List<Integer> list = iBookStudentService.findByDate(text);
        List<Integer> list1 = notifiService.findAllId();
        Page<Notification> notificationList = notifiService.findAll(pageable);
        for (int i=0;i<list.size();i++){
            boolean check=true;
            for (int j=0;j<list1.size();j++){
                if (list.get(i)==list1.get(j)){
                    check=false;
                    break;
                }
            }
            if (check){
                notifiService.setValue(list.get(i));
            }
        }
        modelMap.addAttribute("list", notificationList);
        return "notification/home";
    }

}
