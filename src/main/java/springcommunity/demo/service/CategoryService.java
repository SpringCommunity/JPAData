package springcommunity.demo.service;

import java.util.List;

import springcommunity.demo.bean.Book;
import springcommunity.demo.bean.Category;

public interface CategoryService {
    /*List tất cả category có trong database*/
    public List<Category> findAllCategories();
    /*Get đối tượng mục lục dựa theo tên*/
    public Category findByName(String name);
    /*Get đối tượng mục lục dựa theo id*/
    public Category findById(int id);
    
    public void saveBooks(List<Book> books);
}
