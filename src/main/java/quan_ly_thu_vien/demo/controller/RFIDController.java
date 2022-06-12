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
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        List<StudentOnDay> studentOnDays = iStudentOnDayService.findAll();
        StudentOnDay studentOnDay = new StudentOnDay();
        LocalDateTime current = LocalDateTime.now();
        //sử dụng class DateTimeFormatter để định dạng ngày giờ theo kiểu pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        //sử dụng phương thức format() để định dạng ngày giờ hiện tại rồi gán cho chuỗi formatted
        String formatted = current.format(formatter);
        for (Integer i = 0 ; i < studentIds.size() ; i++){
            if (studentIds.get(i).getIdCard().equals(ID)){
                studentOnDay.setName(studentIds.get(i).getName());
                studentOnDay.setDate(studentIds.get(i).getDate());
                studentOnDay.setEmail(studentIds.get(i).getEmail());
                studentOnDay.setClassName(studentIds.get(i).getClassName());
                studentOnDay.setIdCard(studentIds.get(i).getIdCard());
                if (studentIds.get(i).getStatus()) {
                    studentOnDay.setDateIn(formatted);
                    studentOnDay.setDateOut("0");
                    studentIds.get(i).setStatus(false);
                }
                if (!studentIds.get(i).getStatus()) {
                    studentOnDay.setDateOut(formatted);
                    studentIds.get(i).setStatus(true);
                }
                iStudentOnDayService.save(studentOnDay);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
