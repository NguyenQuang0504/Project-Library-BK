package quan_ly_thu_vien.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String idCard;

    public StudentId() {
    }

    public StudentId(Integer id, String idCard) {
        this.id = id;
        this.idCard = idCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
