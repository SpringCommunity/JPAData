package springcommunity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcommunity.demo.bean.User;
import springcommunity.demo.repositores.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repos;

	@Override
	public User findByUsername(String username) {
		return repos.findByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {
		return repos.findAll();
	}

	
	
      
}
