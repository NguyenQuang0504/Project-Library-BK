package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quan_ly_thu_vien.demo.model.StudentId;
import quan_ly_thu_vien.demo.model.StudentOnDay;
import quan_ly_thu_vien.demo.service.IStudentId;
import quan_ly_thu_vien.demo.service.IStudentOnDayService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class RFIDController {
    @Autowired
    private IStudentId iStudentId;

    @Autowired
    private IStudentOnDayService iStudentOnDayService;

    @GetMapping("/rfid")
    public ResponseEntity<StudentId> getRFID(@RequestParam String ID){
        System.out.println(ID);
        List<StudentId> studentIds = iStudentId.findAll();
        LocalDate dateStart = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = dateStart.format(formatters);
        for (Integer i = 0 ; i < studentIds.size() ; i++){
            if (studentIds.get(i).getIdCard().equals(ID)){
                StudentOnDay studentOnDay = new StudentOnDay();
                studentOnDay.setName(studentIds.get(i).getName());
                studentOnDay.setDate(studentIds.get(i).getDate());
                studentOnDay.setEmail(studentIds.get(i).getEmail());
                studentOnDay.setClassName(studentIds.get(i).getClassName());
                studentOnDay.setIdCard(studentIds.get(i).getIdCard());
                studentOnDay.setDateIn(text);
                studentOnDay.setDateOut(text);
                iStudentOnDayService.save(studentOnDay);
                System.out.println(studentIds.get(i).getName());
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
