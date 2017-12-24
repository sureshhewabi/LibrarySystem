package lk.dhamma.library.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    private String id;
    @NotEmpty
    private String fullName;
    private String address;
    private Date dob;
    private String sex;
    private Integer admittedGrade;
    private String contactNo1;
    private String contactNo2;
    private String contactNo3;
    private String fatherName;
    private String motherName;
    private Date admittedDate;
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "student")
    private List<Borrowal> borrowals;

    public Student() {

    }

    public Student(String id, String fullName, String address, Date dob, String sex, Integer admittedGrade, String contactNo1, String contactNo2, String contactNo3, String fatherName, String motherName, Date admittedDate, String status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.admittedGrade = admittedGrade;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.contactNo3 = contactNo3;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.admittedDate = admittedDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAdmittedGrade() {
        return admittedGrade;
    }

    public void setAdmittedGrade(Integer admittedGrade) {
        this.admittedGrade = admittedGrade;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getContactNo3() {
        return contactNo3;
    }

    public void setContactNo3(String contactNo3) {
        this.contactNo3 = contactNo3;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getAdmittedDate() {
        return admittedDate;
    }

    public void setAdmittedDate(Date admittedDate) {
        this.admittedDate = admittedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Borrowal> getBorrowals() {
        return borrowals;
    }

    public void setBorrowals(List<Borrowal> borrowals) {
        this.borrowals = borrowals;
    }
}
