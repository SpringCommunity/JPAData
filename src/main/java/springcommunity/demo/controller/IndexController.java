package springcommunity.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springcommunity.demo.bean.Book;
import springcommunity.demo.bean.Category;
import springcommunity.demo.bean.User;
import springcommunity.demo.service.BookService;
import springcommunity.demo.service.CategoryService;
import springcommunity.demo.service.UserService;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService cateService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("user", new User());
		model.addAttribute("users", users);
		return "login";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String checkIndex(@ModelAttribute(value = "user") User input) {
		User user = userService.findByUsername(input.getUsername());
		return (user != null & user.getPassword().equals(input.getPassword())) ? "redirect:home" : "login";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		Book book = new Book();
		List<Book> books = bookService.findAllBooks();
		List<Category> categories = cateService.findAllCategories();
		model.addAttribute("book", book);
		model.addAttribute("books", books);
		model.addAttribute("categories", categories);
		return "home";
	}

	
	@RequestMapping(value = "sort", method = RequestMethod.POST)
	public String sortByCateId(@RequestParam(value = "categoryId") Integer cateId, Model model) {
		Book book = new Book();
		List<Category> categories = cateService.findAllCategories();
		if (cateId == 0) {
            return "redirect:home";
		} else {
			List<Book> books = bookService.findBooksByCategory(cateId);
			if (books.size() == 0) {
				model.addAttribute("books", new ArrayList<Book>());
			} else {
				model.addAttribute("books", books);
			}
			model.addAttribute("categories", categories);
			model.addAttribute("book", book);
			return "home";
		}
	}

	@RequestMapping(value = "action", method = RequestMethod.GET)
	public String showHome(@RequestParam(value="bookId") Long bookId, 
			@RequestParam(value = "action") String action, Model model) {
		if (action.equalsIgnoreCase("Edit")) {
			System.out.println(bookId);
			Book book = bookService.findBookById(bookId);
			List<Category> categories = cateService.findAllCategories();
			model.addAttribute("book", book);
			model.addAttribute("categories", categories);
			 return "update";
		}
		if (action.equalsIgnoreCase("Delete")) {
			bookService.deleteBookById(bookId);
			return "redirect:home";
		}
		 else {
			 return "home";
		}
		
	}

	@RequestMapping(value = "createbook", method = RequestMethod.POST)
	public String createBook(@ModelAttribute(value = "book") Book input) {
		   System.out.println("cate "+input.getCategory().getId());
		   System.out.println("name "+input.getName());
			bookService.createBook(input);
		    return "redirect:home";
		    
	}
	
	
	@RequestMapping(value = "book", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute(value="book") Book book ){
		bookService.editBook(book);
		return "redirect:home";
	}
	
}
