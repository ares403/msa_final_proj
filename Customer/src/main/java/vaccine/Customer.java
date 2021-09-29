package vaccine;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Customer_table")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Long vaccineId;
    private String vaccineName;
    private String reserveStatus;

    @PostPersist
    public void onPostPersist(){
        VaccineReserved vaccineReserved = new VaccineReserved();
        BeanUtils.copyProperties(this, vaccineReserved);
        vaccineReserved.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){
        VaccineCanceled vaccineCanceled = new VaccineCanceled();
        BeanUtils.copyProperties(this, vaccineCanceled);
        vaccineCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreRemove
    public void onPreRemove(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }
    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }




}