package xtramiles.task.cleanArc.useCases.port.output;

import org.springframework.stereotype.Repository;
import xtramiles.task.cleanArc.entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepositoryPort {

    Student save(Student student);
    List<Student> findAll();
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudentById(Long id);
}
