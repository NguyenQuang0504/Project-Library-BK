package quan_ly_thu_vien.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monitoring")
public class MonitoringController {
    @GetMapping("/home")
    public String home(){
        return "monitoring/home";
    }
}
