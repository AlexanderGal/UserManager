package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>{
}