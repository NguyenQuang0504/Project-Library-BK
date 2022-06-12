package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quan_ly_thu_vien.demo.model.StudentId;
import quan_ly_thu_vien.demo.service.IStudentId;

@RestController
public class RFIDController {
    @Autowired
    private IStudentId iStudentId;

    @GetMapping("/rfid")
    public ResponseEntity<StudentId> getRFID(@RequestParam String ID){
        StudentId student = new StudentId();
        student.setIdCard(ID);
        iStudentId.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
