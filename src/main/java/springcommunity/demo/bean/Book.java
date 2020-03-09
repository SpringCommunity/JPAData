package springcommunity.demo.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="id")
	   private Long id;
	   
	   @Column(name="isbn")
       private String isbn;
	   
	   @Column(name="name", nullable=false)
       private String name;
	   
	   @Column(name="author", nullable=false)
       private String author;
	   
	   @Column(name="publisheddate", nullable=false)
       private Date publishedDate;
       
	   @ManyToOne(cascade=CascadeType.ALL)
	   @JoinColumn(name="categoryid")
       private Category category;
       
	public Book() {
		super();
	}
	public Book(Long id, String isbn, String name, String author, Date publishedDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.publishedDate = publishedDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
       
	
       
}
