package main.service;

import java.util.List;

import main.entity.User;

public interface UserService {
	User findById(Long id);
	List<User> findAll();
	void saveOrUpdate(User user);
	void delete(Long id);
}