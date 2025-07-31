package xtramiles.task.cleanArc.useCases.dto;

import java.time.LocalDate;

public record StudentResponseDTO(
        Long id,
        String nim,
        String namaLengkap,
        Integer umur
) {}
