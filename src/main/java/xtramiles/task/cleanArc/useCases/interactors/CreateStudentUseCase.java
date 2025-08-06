package xtramiles.task.cleanArc.useCases.interactors;

import xtramiles.task.cleanArc.entities.Student;
import xtramiles.task.cleanArc.useCases.dto.StudentRequestDTO;
import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;
import xtramiles.task.cleanArc.useCases.port.input.CreateStudentInputPort;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CreateStudentUseCase implements CreateStudentInputPort {

    private final StudentRepositoryPort studentRepositoryPort;

    public CreateStudentUseCase(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO request) {
        Student student = new Student(request.nim(), request.namaDepan(), request.namaBelakang(), request.tanggalLahir());

        int umur = Period.between(student.getTanggalLahir(), LocalDate.now()).getYears();


        if (umur<=0) {
            throw new RuntimeException("Error");
        } else {

            Student savedStudent = studentRepositoryPort.save(student);

            StudentResponseDTO response = mapToResponse(savedStudent);

            return response;
        }


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
