package springcommunity.demo.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springcommunity.demo.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
	 List<User> findAll();
}
