// Cau hinh lay danh sach sinh vien qua han tra sach va luu vao noti moi ngay luc 8h sang
package quan_ly_thu_vien.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import quan_ly_thu_vien.demo.service.IBookStudentService;
import quan_ly_thu_vien.demo.service.INotifiService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Configuration
@EnableScheduling
public class AutoNotifi {
    @Autowired
    private IBookStudentService iBookStudentService;
    @Autowired
    private INotifiService notifiService;
    @Scheduled(cron = "0 0 8 * * *")
        public void addData() {
            // Chuyen mac dinh sang mm/dd/yyy
            LocalDate dateStart = LocalDate.now();
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String text = dateStart.format(formatters);
            List<Integer> list = iBookStudentService.findByDate(text);
            List<Integer> list1 = notifiService.findAllId();
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
        }
}