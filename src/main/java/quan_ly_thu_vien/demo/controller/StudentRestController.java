package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quan_ly_thu_vien.demo.model.Student;
import quan_ly_thu_vien.demo.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(String Name) {
        System.out.println(Name);
        List<Student> listResponseEntity = iStudentService.findByName(Name);
        return new ResponseEntity<>(listResponseEntity, HttpStatus.OK);
    }
}
