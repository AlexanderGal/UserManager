package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.entity.Frameworks;

public interface FrameworksRepository extends JpaRepository<Frameworks, Long>{
}