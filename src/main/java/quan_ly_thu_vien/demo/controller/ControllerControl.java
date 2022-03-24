package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import quan_ly_thu_vien.demo.model.Equipment;
import quan_ly_thu_vien.demo.service.IEquimentService;

import java.util.List;

@RestController
@RequestMapping("/control")
public class ControllerControl {
    @Autowired
    private IEquimentService iEquimentService;
    @GetMapping("/home")
    public ModelAndView homeControl(){
        List<Equipment> equipmentList = iEquimentService.findAll();
        return new ModelAndView("homeControl/home", "listEquipment", equipmentList);
    }
    @GetMapping("/lamp1")
    public void controlLamp1(String Status){
        Integer status = Integer.parseInt(Status);
        if (status == 0){
            status =1;
        }
        else {
            status = 0;
        }
        iEquimentService.updateStatusL(status);
    }
    @GetMapping("/fan1")
    public void controlFan1(String Status){
        Integer status = Integer.parseInt(Status);
        if (status==0){
            status=1;
        }
        else {
            status=0;
        }
        iEquimentService.updateStatusF(status);
    }
    @GetMapping("/responseLamp1")
    public String responseLamp1(){
        String status = iEquimentService.findStatusLamp1();
        return status;
    }
}
