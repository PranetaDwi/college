package xtramiles.task.cleanArc.useCases.port.input;

import xtramiles.task.cleanArc.useCases.dto.StudentRequestDTO;
import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;

public interface CreateStudentInputPort {

    StudentResponseDTO createStudent(StudentRequestDTO request);

}
