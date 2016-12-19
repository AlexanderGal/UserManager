package main.service;

import java.util.List;
import main.entity.Skill;

public interface SkillService {
	 Skill findById(Long id);
	 void saveOrUpdate(Skill skill);
	 List<Skill> findAll();
	 void delete(Long id);
}