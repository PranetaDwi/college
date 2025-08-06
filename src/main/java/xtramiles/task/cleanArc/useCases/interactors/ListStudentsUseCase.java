package xtramiles.task.cleanArc.useCases.interactors;

import xtramiles.task.cleanArc.entities.Student;
import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;
import xtramiles.task.cleanArc.useCases.port.input.ListStudentsInputPort;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class ListStudentsUseCase implements ListStudentsInputPort {

    private final StudentRepositoryPort studentRepositoryPort;

    public ListStudentsUseCase(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public List<StudentResponseDTO> listStudents() {

        List<Student> students = studentRepositoryPort.findAll();

        List<StudentResponseDTO> responses = students.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

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
                student.getNamaDepan(),
                student.getNamaBelakang(),
                namaLengkap,
                student.getTanggalLahir().toString(),
                umur
        );
    }
}
