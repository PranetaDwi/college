package xtramiles.task.cleanArc.useCases.dto;

import jakarta.annotation.Nullable;

import java.time.LocalDate;

public record StudentRequestDTO(

        String nim,
        String namaDepan,
        @Nullable String namaBelakang,
        LocalDate tanggalLahir

) {}

