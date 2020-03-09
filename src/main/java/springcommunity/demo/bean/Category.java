package springcommunity.demo.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @Entity giúp Spring xác định đây là lớp Model khi scan
 * @Table giúp map đối tượng vào một bảng tương ứng trong cơ sở dữ liệu
 * @Id xác định thuộc tính nào của model sẽ dùng làm khóa chính
 * @Column giúp map các thuộc tính của model với từng cột tương ứng trong bảng
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private short id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<Book> books;

	public Category() {
		super();
	}

	public Category(short id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	

}
