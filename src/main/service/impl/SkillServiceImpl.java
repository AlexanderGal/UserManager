package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.entity.Skill;
import main.repository.SkillRepository;
import main.service.SkillService;

public class SkillServiceImpl implements SkillService {
	private SkillRepository skillRepository;
	
	@Autowired
	public void setSkillRepository(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public Skill findById(Long id) {
		return skillRepository.findOne(id);
	}

	@Override
	public void saveOrUpdate(Skill skill) {
		skillRepository.saveAndFlush(skill);
	}

	@Override
	public List<Skill> findAll() {
		return skillRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		if (findById(id) != null) {
			skillRepository.delete(id);
		}
	}
}