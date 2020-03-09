package springcommunity.demo.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springcommunity.demo.bean.Book;
import springcommunity.demo.bean.Category;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
	/*@Modifying(clearAutomatically = true)
	@Query("INSERT INTO book (isbn, name, author, categoryid, publisheddate) values (:isbn, :name, :author, :categoryid, :publisheddate)")
	void saveBook(@Param("isbn") String isbn, @Param("name") String name, @Param("author") String author, @Param("categoryid") short id, @Param("publisheddate") Date publishedDate);
     */
	/*Khai báo này giúp EntityManager sẽ tự động clear trước khi chạy query. EntityManager là một interface cung cấp 
	 * các API giúp tương tác với các Entity trong cơ sở dữ liệu*/
	/*@Modifying(clearAutomatically = true)
	@Query("UPDATE book SET isbn=:isbn , name=:name, author=:author, categoryid=:categoryid, publisheddate=:publisheddate WHERE id=:id")
	void updateBook(@Param("isbn") String isbn, @Param("name") String name, @Param("author") String author, @Param("categoryid") short categoryid, @Param("publisheddate") Date publishedDate, @Param("id") Long id );*/
	 Book findByIsbn(String isbn);
	 Book findByName(String name);
	 List<Book> findByCategory(Category category);
}