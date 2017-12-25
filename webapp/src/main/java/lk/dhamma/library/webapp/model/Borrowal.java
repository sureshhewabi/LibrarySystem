package lk.dhamma.library.webapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Borrowals")
public class Borrowal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date borrowalDate;
    private Date dueDate;
    private Date handoverDate;
    private String issuedBy;
    private String revceivedBy;
    private Double dueFine;
    private Double finePaid;
    @ManyToOne
    @JoinColumn (name="student_id")
    @JsonManagedReference
    private Student student;
    @ManyToOne
    @JoinColumn (name="book_id")
    @JsonManagedReference
    private Book book;

    public Borrowal() {
    }

    public Borrowal(Date borrowalDate, Date dueDate, Date handoverDate, String issuedBy, String revceivedBy, Double dueFine, Double finePaid) {
        this.borrowalDate = borrowalDate;
        this.dueDate = dueDate;
        this.handoverDate = handoverDate;
        this.issuedBy = issuedBy;
        this.revceivedBy = revceivedBy;
        this.dueFine = dueFine;
        this.finePaid = finePaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBorrowalDate() {
        return borrowalDate;
    }

    public void setBorrowalDate(Date borrowalDate) {
        this.borrowalDate = borrowalDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(Date handoverDate) {
        this.handoverDate = handoverDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getRevceivedBy() {
        return revceivedBy;
    }

    public void setRevceivedBy(String revceivedBy) {
        this.revceivedBy = revceivedBy;
    }

    public Double getDueFine() {
        return dueFine;
    }

    public void setDueFine(Double dueFine) {
        this.dueFine = dueFine;
    }

    public Double getFinePaid() {
        return finePaid;
    }

    public void setFinePaid(Double finePaid) {
        this.finePaid = finePaid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
