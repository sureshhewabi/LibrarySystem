package lk.dhamma.library.webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    private String accessionNo;
    private String title;
    private String author;
    private String publisher;
    private Integer page;
    private Double price;
    private String source;
    private Double category;
    private String notes;
    @JsonBackReference
    @OneToMany(mappedBy = "book")
    private List<Borrowal> borrowals;

    public Book() {

    }

    public Book(String accessionNo, String title, String author, String publisher, Integer page, Double price, String source, Double category, String notes) {
        this.setAccessionNo(accessionNo);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setPage(page);
        this.setPrice(price);
        this.setSource(source);
        this.setCategory(category);
        this.setNotes(notes);
    }


    public String getAccessionNo() {
        return accessionNo;
    }

    public void setAccessionNo(String accessionNo) {
        this.accessionNo = accessionNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getCategory() {
        return category;
    }

    public void setCategory(Double category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Borrowal> getBorrowals() {
        return borrowals;
    }

    public void setBorrowals(List<Borrowal> borrowals) {
        this.borrowals = borrowals;
    }
}
