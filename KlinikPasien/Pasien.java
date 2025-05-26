package KlinikPasien;

public class Pasien {
    private int noAntrian;
    private String nama;
    private String jenisKelamin;
    private int usia;
    private String alamat;
    private String keluhan;
    private String statusPasien;

    public Pasien(int noAntrian, String nama,String jenisKelamin, int usia,String alamat, String keluhan, String statusPasien) {
        this.noAntrian = noAntrian;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.alamat = alamat;
        this.keluhan = keluhan; 
        this.statusPasien = statusPasien;
    
        
    }
    public int getNoAntrian() {
        return noAntrian;
    }
    public void setNoAntrian(int noAntrian) {
        this.noAntrian = noAntrian;
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
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
