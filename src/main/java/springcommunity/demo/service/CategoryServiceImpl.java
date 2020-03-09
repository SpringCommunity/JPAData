package springcommunity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcommunity.demo.bean.Book;
import springcommunity.demo.bean.Category;
import springcommunity.demo.repositores.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    
	@Autowired
	private CategoryRepository repos;
	
	@Override
	public List<Category> findAllCategories() {
		return repos.findAll();
	}

	@Override
	public Category findByName(String name) {
		return repos.findByName(name);
	}

	@Override
	public Category findById(int id) {
		return repos.findById((short) id);
	}

	@Override
	public void saveBooks(List<Book> books){
		Category cate = new Category();
		cate.setBooks(books);
		repos.saveAndFlush(cate);
	}
}
