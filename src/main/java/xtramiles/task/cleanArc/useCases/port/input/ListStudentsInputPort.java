package xtramiles.task.cleanArc.useCases.port.input;

import xtramiles.task.cleanArc.useCases.dto.StudentResponseDTO;

import java.util.List;

public interface ListStudentsInputPort {

    List<StudentResponseDTO> listStudents();

}
