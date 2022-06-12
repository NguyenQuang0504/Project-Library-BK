package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import quan_ly_thu_vien.demo.model.StudentOnDay;
import quan_ly_thu_vien.demo.repository.IStudentOnDay;
import quan_ly_thu_vien.demo.service.IStudentOnDayService;

import java.util.List;

@Controller
@RequestMapping("/monitoring")
public class MonitoringController {
    @Autowired
    private IStudentOnDayService iStudentOnDayService;

    @GetMapping("/home")
    public String home(ModelMap modelMap){
        List<StudentOnDay> studentOnDays = iStudentOnDayService.findAll();
        modelMap.addAttribute("studentList", studentOnDays);
        return "monitoring/home";
    }
}
