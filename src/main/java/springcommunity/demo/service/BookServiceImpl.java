package springcommunity.demo.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcommunity.demo.bean.Book;
import springcommunity.demo.bean.Category;
import springcommunity.demo.repositores.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	//@PersistenceContext
	@Autowired
    private EntityManager entityManager;
	
    @Autowired
    private BookRepository repos;

	@Override
	public Book findBookByIsbn(String isbn) {
		return repos.findByIsbn(isbn);
	}

	@Override
	public Book findByName(String name) {
		return repos.findByName(name) ;
	}

	@Override
	public List<Book> findAllBooks() {
		return repos.findAll();
	}


	@Override
	public void deleteBookById(Long id) {
        repos.delete(id);		
	}


	@Override
	public Book findBookById(Long id) {
		return repos.findOne(id);
	}

	@Override
	public List<Book> findBooksByCategory(int cateId) {
		Category cate = new Category();
		cate.setId((short) cateId);
		return repos.findByCategory(cate);
	}

	@Override
	public void saveBook(String isbn, String name, String author, short cateId, Date date) {
		// repos.saveBook(isbn, name, author, cateId, date);
	}

	@Override
	public void createBook(Book book) {
		entityManager.persist(book);
	}
	@Override
	public void editBook(Book book) {
		entityManager.merge(book);
	}
	@Override
	public void saveBook(Book book) {
		repos.saveAndFlush(book);
	}

	@Override
	public void updateBook(Book book) {
          repos.saveAndFlush(book);
	}

	


}
