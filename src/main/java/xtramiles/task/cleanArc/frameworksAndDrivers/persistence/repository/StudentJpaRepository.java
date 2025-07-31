package xtramiles.task.cleanArc.frameworksAndDrivers.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xtramiles.task.cleanArc.frameworksAndDrivers.persistence.entity.StudentEntity;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}
