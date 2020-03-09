package springcommunity.demo.service;

import java.sql.Date;
import java.util.List;

import springcommunity.demo.bean.Book;

public interface BookService {
	public Book findBookById(Long id);
	public Book findBookByIsbn(String isbn);
    public Book findByName(String name);
    public List<Book> findAllBooks();
    public void saveBook(String isbn, String name, String author, short cateId, Date date);
    public void deleteBookById(Long id);
	public List<Book> findBooksByCategory(int cateId);
	public void createBook(Book book);
	public void saveBook(Book book);
	public void updateBook(Book book);
	public void editBook(Book book);
}
