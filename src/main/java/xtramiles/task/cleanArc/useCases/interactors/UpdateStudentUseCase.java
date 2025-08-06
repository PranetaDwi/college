package xtramiles.task.cleanArc.useCases.interactors;

import xtramiles.task.cleanArc.entities.Student;
import xtramiles.task.cleanArc.useCases.dto.StudentRequestDTO;
import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;
import xtramiles.task.cleanArc.useCases.port.input.UpdateStudentInputPort;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class UpdateStudentUseCase implements UpdateStudentInputPort {

    private final StudentRepositoryPort studentRepositoryPort;

    public UpdateStudentUseCase(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO request) {

        Optional<Student> existingStudentOpt = studentRepositoryPort.getStudentById(id);

        if (existingStudentOpt.isEmpty()) {
            throw new RuntimeException("Student not found with ID: " + id);
        }

        Student student = existingStudentOpt.get();

        student.setNim(request.nim());
        student.setNamaDepan(request.namaDepan());
        student.setNamaBelakang(request.namaBelakang());
        student.setTanggalLahir(request.tanggalLahir());

        int umur = Period.between(student.getTanggalLahir(), LocalDate.now()).getYears();

        if (umur<=0) {
            throw new RuntimeException("Error");
        } else {

            Student updatedStudent = studentRepositoryPort.updateStudent(id, student);

            return mapToResponse(updatedStudent);
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
