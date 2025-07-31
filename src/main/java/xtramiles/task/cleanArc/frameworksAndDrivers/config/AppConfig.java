package xtramiles.task.cleanArc.frameworksAndDrivers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xtramiles.task.cleanArc.useCases.interactors.*;
import xtramiles.task.cleanArc.useCases.port.input.*;
import xtramiles.task.cleanArc.useCases.port.output.StudentRepositoryPort;

@Configuration
public class AppConfig {

    @Bean
    public CreateStudentInputPort createStudentInputPort(StudentRepositoryPort studentRepositoryPort) {
        return new CreateStudentUseCase(studentRepositoryPort);
    }

    @Bean
    public ListStudentsInputPort listStudentsInputPort(StudentRepositoryPort studentRepositoryPort) {
        return new ListStudentsUseCase(studentRepositoryPort);
    }

    @Bean
    public DetailStudentInputPort detailStudentInputPort(StudentRepositoryPort studentRepositoryPort) {
        return new DetailStudentUseCase(studentRepositoryPort);
    }

    @Bean
    public UpdateStudentInputPort updateStudentInputPort(StudentRepositoryPort studentRepositoryPort) {
        return new UpdateStudentUseCase(studentRepositoryPort);
    }

    @Bean
    public DeleteStudentInputPort deleteStudentInputPort(StudentRepositoryPort studentRepositoryPort) {
        return new DeleteStudentUseCase(studentRepositoryPort);
    }

}
