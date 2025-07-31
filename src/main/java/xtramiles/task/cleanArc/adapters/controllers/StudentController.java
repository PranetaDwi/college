package xtramiles.task.cleanArc.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xtramiles.task.cleanArc.useCases.dto.StudentRequestDTO;
import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;
import xtramiles.task.cleanArc.useCases.port.input.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final CreateStudentInputPort createStudentInputPort;
    private final ListStudentsInputPort listStudentsInputPort;
    private final DetailStudentInputPort detailStudentInputPort;
    private final UpdateStudentInputPort updateStudentInputPort;
    private final DeleteStudentInputPort deleteStudentInputPort;

    public StudentController(CreateStudentInputPort createStudentInputPort, ListStudentsInputPort listStudentsInputPort, DetailStudentInputPort detailStudentInputPort, UpdateStudentInputPort updateStudentInputPort, DeleteStudentInputPort deleteStudentInputPort) {
        this.createStudentInputPort = createStudentInputPort;
        this.listStudentsInputPort = listStudentsInputPort;
        this.detailStudentInputPort = detailStudentInputPort;
        this.updateStudentInputPort = updateStudentInputPort;
        this.deleteStudentInputPort = deleteStudentInputPort;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent (@RequestBody StudentRequestDTO request){

        StudentResponseDTO response = createStudentInputPort.createStudent(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> listUsers(){
        List<StudentResponseDTO> response = listStudentsInputPort.listStudents();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudentResponseDTO>> detailStudent(@PathVariable Long id) {
        Optional<StudentResponseDTO> response = detailStudentInputPort.detailStudent(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent (@PathVariable Long id, @RequestBody StudentRequestDTO request){
        StudentResponseDTO response = updateStudentInputPort.updateStudent(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        deleteStudentInputPort.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
