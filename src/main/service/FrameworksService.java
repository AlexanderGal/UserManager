package main.service;

import java.util.List;

import main.entity.Frameworks;

public interface FrameworksService {
	Frameworks findById(Long id);
	List<Frameworks> findAll();
	void saveOrUpdate(Frameworks frameworks);
	void delete(Long id);
}