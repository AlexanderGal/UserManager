package main.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.entity.User;
import main.repository.UserRepository;
import main.service.UserService;

public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void delete(Long id) {
		if(findById(id) != null){
		userRepository.delete(id);	
		}
	}
}