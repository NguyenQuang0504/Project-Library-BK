package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import quan_ly_thu_vien.demo.model.Equipment;
import quan_ly_thu_vien.demo.service.IEquimentService;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IEquimentService iEquimentService;
    @GetMapping("/display")
    public ModelAndView home(){
        List<Equipment> equipmentList = iEquimentService.findAll();
        return new ModelAndView("home/home", "listEquipment", equipmentList);
    }
    @GetMapping("/getListEquipment")
    public ResponseEntity<List<Equipment>> getListEquipment(){
        List<Equipment> equipmentList = iEquimentService.findAll();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }
    @GetMapping("/update/{temperature}/{humidity}/{gas}/{lamp}/{fan}")
    public void update(@PathVariable Integer temperature, @PathVariable Integer humidity, @PathVariable Integer gas, @PathVariable Integer lamp, @PathVariable Integer fan){
        iEquimentService.updateStatusT(temperature);
        iEquimentService.updateStatusH(humidity);
        iEquimentService.updateStatusG(gas);
        iEquimentService.updateStatusL(lamp);
        iEquimentService.updateStatusF(fan);
    }
}
