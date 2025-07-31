package xtramiles.task.cleanArc.useCases.interactors;

import xtramiles.task.cleanArc.entities.Student;
import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;
import xtramiles.task.cleanArc.useCases.port.input.DetailStudentInputPort;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class DetailStudentUseCase implements DetailStudentInputPort {

    private final StudentRepositoryPort studentRepositoryPort;

    public DetailStudentUseCase(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public Optional<StudentResponseDTO> detailStudent(Long id) {
       Optional<Student> student = studentRepositoryPort.getStudentById(id);

        Optional<StudentResponseDTO> responses = student
                .map(this::mapToResponse);

        return responses;

    }

    private StudentResponseDTO mapToResponse(Student student){

        String namaLengkap;

        if (student.getId() == null ){
            throw new IllegalStateException("Saved User entity must have an ID");
        }

        int umur = Period.between(student.getTanggalLahir(), LocalDate.now()).getYears();

        if (student.getNamaBelakang() != null) {
            namaLengkap = student.getNamaDepan() + " " + student.getNamaBelakang();
        } else {
            namaLengkap = student.getNamaDepan();
        }


        return new StudentResponseDTO(
                student.getId(),
                student.getNim(),
                namaLengkap,
                umur
        );
    }
}


