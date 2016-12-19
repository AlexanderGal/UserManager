package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.entity.Frameworks;
import main.repository.FrameworksRepository;
import main.service.FrameworksService;

public class FrameworksServiceImpl implements FrameworksService{
	FrameworksRepository frameworksRepository;
	
	@Autowired
	void setFrameWorksRepository(FrameworksRepository frameworksRepository){
		this.frameworksRepository = frameworksRepository;
	}

	@Override
	public Frameworks findById(Long id) {
		return frameworksRepository.findOne(id);
	}

	@Override
	public List<Frameworks> findAll() {
		return frameworksRepository.findAll();
	}

	@Override
	public void saveOrUpdate(Frameworks frameworks) {
		frameworksRepository.saveAndFlush(frameworks);
	}

	@Override
	public void delete(Long id) {
		if (findById(id) != null) {
			frameworksRepository.delete(id);
		}
	}	
}