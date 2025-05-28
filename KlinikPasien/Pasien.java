package KlinikPasien;

public class Pasien {
    private int id;
    private String nama;
    private String jenisKelamin;
    private int usia;
    private String nomorTelepon;
    private String alamat;
    private String tanggalKunjungan;
    private String keluhan;
    private String statusPasien;

    public Pasien(String nama, String jenisKelamin, int usia,String nomorTelepon, String alamat, String tanggalKunjungan, String keluhan, String statusPasien) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
        this.tanggalKunjungan = tanggalKunjungan;
        this.keluhan = keluhan;
        this.statusPasien = statusPasien;
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

    public String getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    public void setTanggalKunjungan(String tanggalKunjungan) {
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getStatusPasien() {
        return statusPasien;
    }

    public void setStatusPasien(String statusPasien) {
        this.statusPasien = statusPasien;
    }

}
