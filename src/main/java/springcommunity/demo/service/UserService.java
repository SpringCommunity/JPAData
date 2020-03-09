package springcommunity.demo.service;

import java.util.List;

import springcommunity.demo.bean.User;

public interface UserService {
	public User findByUsername(String username);
	public List<User> findAllUsers();
}
