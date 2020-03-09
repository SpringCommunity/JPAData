package springcommunity.demo.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springcommunity.demo.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	List<Category> findAll();

	Category findByName(String name);
	Category findById(short id);
}
