package xtramiles.task.cleanArc.entities;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String nim;
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;

    public Student(String nim, String namaDepan, String namaBelakang, LocalDate tanggalLahir) {

        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM cannot be empty");
        }

        if (namaDepan == null || namaDepan.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama Depan cannot be empty");
        }

        if (tanggalLahir == null) {
            throw new IllegalArgumentException("NIM cannot be empty");
        }

        this.id = null;
        this.nim = nim;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
    }

    public Student(Long id, String nim, String namaDepan, String namaBelakang, LocalDate tanggalLahir){

        this.id = id;
        this.nim = nim;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;

    }

    public Long getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", nim='" + nim + '\'' +
                ", nama depan='" + namaDepan + '\'' +
                ", nama belakang='" + namaBelakang + '\'' +
                ", tanggal lahir'" + tanggalLahir + '\'' +
                '}';
    }
}
