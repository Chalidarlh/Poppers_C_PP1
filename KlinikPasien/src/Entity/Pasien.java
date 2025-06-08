package KlinikPasien.src.Entity;

import java.time.LocalDate;

public class Pasien {
    private static int idAwal = 1;
    private int id;
    private String nama;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
    private int usia;
    private String nomorTelepon;
    private String alamat;
    private LocalDate tanggalKunjungan;
    private String keluhan;

    public Pasien(String nama, LocalDate tanggalLahir, String jenisKelamin, int usia, String nomorTelepon,
            String alamat, LocalDate tanggalKunjungan, String keluhan) {
        this.id = idAwal++;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
        this.tanggalKunjungan = tanggalKunjungan;
        this.keluhan = keluhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    public void setTanggalKunjungan(LocalDate tanggalKunjungan) {
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
    public String toString() {
        return id + " " + nama + " " + tanggalLahir + " " + jenisKelamin + " " + usia + " " + nomorTelepon + " " + alamat + " " + tanggalKunjungan + " " + keluhan;
    }
}
