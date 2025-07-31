package xtramiles.task.cleanArc.adapters.gateways;

import org.springframework.stereotype.Repository;
import xtramiles.task.cleanArc.entities.Student;
import xtramiles.task.cleanArc.frameworksAndDrivers.persistence.entity.StudentEntity;
import xtramiles.task.cleanArc.frameworksAndDrivers.persistence.repository.StudentJpaRepository;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepositoryPort {

    private final StudentJpaRepository studentJpaRepository;

    public StudentRepositoryImpl(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public Student save(Student student) {
        StudentEntity entity = new StudentEntity(
                student.getNim(),
                student.getNamaDepan(),
                student.getNamaBelakang(),
                student.getTanggalLahir()
        );

        StudentEntity savedEntity = studentJpaRepository.save(entity);

        Student savedStudent = new Student(
                savedEntity.getId(),
                savedEntity.getNim(),
                savedEntity.getNamaDepan(),
                savedEntity.getNamaBelakang(),
                savedEntity.getTanggalLahir()
        );

        return savedStudent;
    }

    @Override
    public List<Student> findAll() {
        List<StudentEntity> entities = studentJpaRepository.findAll();

        List<Student> domainStudents = entities.stream()
                .map(entity -> new Student(
                        entity.getId(),
                        entity.getNim(),
                        entity.getNamaDepan(),
                        entity.getNamaBelakang(),
                        entity.getTanggalLahir()
                ))
                .collect(Collectors.toList());

        return domainStudents;
    }

    @Override
    public Optional<Student> getStudentById(Long id){
        Optional<StudentEntity> entities = studentJpaRepository.findById(id);

        Optional<Student> domainStudents = entities
                .map(entity -> new Student(
                        entity.getId(),
                        entity.getNim(),
                        entity.getNamaDepan(),
                        entity.getNamaBelakang(),
                        entity.getTanggalLahir()
                ));

        return domainStudents;

    }

    @Override
    public Student updateStudent(Long id, Student student) {
        StudentEntity entity = studentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

        entity.setNim(student.getNim());
        entity.setNamaDepan(student.getNamaDepan());
        entity.setNamaBelakang(student.getNamaBelakang());
        entity.setTanggalLahir(student.getTanggalLahir());

        StudentEntity savedEntity = studentJpaRepository.save(entity);

        return new Student(
                savedEntity.getId(),
                savedEntity.getNim(),
                savedEntity.getNamaDepan(),
                savedEntity.getNamaBelakang(),
                savedEntity.getTanggalLahir()
        );
    }

    @Override
    public void deleteStudentById(Long id) {
        studentJpaRepository.deleteById(id);
    }



}
