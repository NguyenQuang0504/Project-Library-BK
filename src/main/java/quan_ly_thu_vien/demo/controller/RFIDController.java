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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String formatted = current.format(formatter);
        for (Integer i = 0 ; i < studentIds.size() ; i++){
            if (studentIds.get(i).getIdCard().equals(ID)){
                if (studentIds.get(i).getStatus()) {
                    studentOnDay.setName(studentIds.get(i).getName());
                    studentOnDay.setDate(studentIds.get(i).getDate());
                    studentOnDay.setEmail(studentIds.get(i).getEmail());
                    studentOnDay.setClassName(studentIds.get(i).getClassName());
                    studentOnDay.setIdCard(studentIds.get(i).getIdCard());
                    studentOnDay.setDateIn(formatted);
                    studentIds.get(i).setStatus(false);
                    iStudentOnDayService.save(studentOnDay);
                    break;
                }
                else if(!studentIds.get(i).getStatus()) {
                    for (Integer j = 0 ; j < studentOnDays.size() ; j++){
                        if (studentOnDays.get(j).getIdCard().equals(ID)){
                            if (studentOnDays.get(j).getDateOut() == null){
                                System.out.println("Vo day roi");
                                studentOnDay = studentOnDays.get(j);
                                studentOnDay.setDateOut(formatted);
                                studentIds.get(i).setStatus(true);
                                iStudentOnDayService.save(studentOnDay);
                            }
                           else{
                                System.out.println("Lỗi");
                            }
                        }
                    }
                }
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
