package xtramiles.task.cleanArc.useCases.interactors;

import xtramiles.task.cleanArc.entities.Student;
import xtramiles.task.cleanArc.useCases.port.input.DeleteStudentInputPort;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

import java.util.Optional;

public class DeleteStudentUseCase implements DeleteStudentInputPort {

    private final StudentRepositoryPort studentRepositoryPort;

    public DeleteStudentUseCase(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepositoryPort.getStudentById(id);

        if (student.isEmpty()) {
            throw new RuntimeException("Student not found with ID: " + id);
        }

        studentRepositoryPort.deleteStudentById(id);
    }
}
