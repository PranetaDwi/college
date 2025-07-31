package xtramiles.task.cleanArc.useCases.port.input;

import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;

import java.util.Optional;

public interface DetailStudentInputPort {

    Optional<StudentResponseDTO> detailStudent(Long id);
}
