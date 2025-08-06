package xtramiles.task.cleanArc.useCases.dto;

import java.time.LocalDate;

public record StudentResponseDTO(
        Long id,
        String nim,
        String namaDepan,
        String namaBelakang,
        String namaLengkap,
        String tanggalLahir,
        Integer umur
) {}
