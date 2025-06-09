package KlinikPasien.src.Services;

import java.io.*;
import java.time.LocalDate;

import KlinikPasien.src.Entity.Pasien;
import KlinikPasien.src.Util.Node;

public class ListPasien {
    Node HEAD;

    public boolean isEmpty() {
        if (HEAD != null) {
            return false;
        } else {
            return true;
        }
    }

    public void simpanSemuaKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pasien.txt"))) {
            Node current = HEAD;
            while (current != null) {
                Pasien p = current.getData();
                writer.write(p.getId() + "," +
                        p.getNama() + "," +
                        p.getTanggalLahir() + "," +
                        p.getJenisKelamin() + "," +
                        p.getUsia() + "," +
                        p.getNomorTelepon() + "," +
                        p.getAlamat() + "," +
                        p.getTanggalKunjungan() + "," +
                        p.getKeluhan());
                writer.newLine();
                current = current.getNext();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke file: " + e.getMessage());
        }
    }

    private void simpanUlangFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pasien.txt"))) {
            Node current = HEAD;
            while (current != null) {
                Pasien p = current.getData();
                String data = p.getId() + "," +
                        p.getNama() + "," +
                        p.getTanggalLahir() + "," +
                        p.getJenisKelamin() + "," +
                        p.getUsia() + "," +
                        p.getNomorTelepon() + "," +
                        p.getAlamat() + "," +
                        p.getTanggalKunjungan() + "," +
                        p.getKeluhan();
                bw.write(data);
                bw.newLine();
                current = current.getNext();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ulang ke file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("pasien.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String nama = parts[1];
                LocalDate tanggalLahir = LocalDate.parse(parts[2]);
                String jenisKelamin = parts[3];
                int usia = Integer.parseInt(parts[4]);
                String nomorTelepon = parts[5];
                String alamat = parts[6];
                LocalDate tanggalKunjungan = LocalDate.parse(parts[7]);
                String keluhan = parts[8];

                Pasien p = new Pasien(nama, tanggalLahir, jenisKelamin, usia, nomorTelepon, alamat, tanggalKunjungan,
                        keluhan);
                addTailTanpaSimpan(p);

            }
        } catch (IOException e) {
            System.out.println("Gagal load data dari file: " + e.getMessage());
        }
    }

    public void addTailTanpaSimpan(Pasien data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            HEAD = newNode;
        } else {
            Node curNode = HEAD;
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(newNode);
        }
    }

    public void addTail(Pasien data) {
        Node posNode = null, curNode = null;

        Node newNode = new Node(data);
        if (isEmpty()) {
            HEAD = newNode;
        } else {
            curNode = HEAD;
            while (curNode != null) {
                posNode = curNode;
                curNode = curNode.getNext();

            }
            posNode.setNext(newNode);
        }
        simpanSemuaKeFile();
    }

    private void dispose(Node node) {
        node.setNext(null);
        node = null;
    }

    public void removeMid(String nama, int usia, String alamat) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node tempNode = HEAD;
        Node preNode = null;

        while (tempNode != null) {
            if (tempNode.getData().getNama().equals(nama) && tempNode.getData().getUsia() == usia
                    && tempNode.getData().getAlamat().equals(alamat)) {
                if (preNode == null) {
                    HEAD = tempNode.getNext();
                } else {
                    preNode.setNext(tempNode.getNext());
                }
                dispose(tempNode);
                simpanUlangFile();
                System.out.println("Pasien dengan nama: " + nama + " berhasil dihapus.");
                return;
            }
            preNode = tempNode;
            tempNode = tempNode.getNext();
        }

        System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
    }

    public int count() {
        Node curNode = HEAD;
        int jumlah = 0;

        while (curNode != null) {
            jumlah = jumlah + 1;
            curNode = curNode.getNext();
        }
        return jumlah;
    }

    public void find(String nama) {
        Node curNode = HEAD;
        boolean ditemukan = false;
        while (curNode != null) {
            if (curNode.getData().getNama().equalsIgnoreCase(nama)) {
                Pasien p = curNode.getData();
                System.out.println("Id                : " + p.getId());
                System.out.println("Nama              : " + p.getNama());
                System.out.println("Tanggal Lahir     : " + p.getTanggalLahir());
                System.out.println("Jenis Kelamin     : " + p.getJenisKelamin());
                System.out.println("Usia              : " + p.getUsia());
                System.out.println("No Telepon        : " + p.getNomorTelepon());
                System.out.println("Alamat            : " + p.getAlamat());
                System.out.println("Tanggal Kunjungan : " + p.getTanggalKunjungan());
                System.out.println("Keluhan           : " + p.getKeluhan());
                System.out.println("--------------------------------------");
                ditemukan = true;
            }
            curNode = curNode.getNext();
        }
        if (!ditemukan) {
            System.out.println("Data pasien tidak ditemukan");
        }
    }

    public void updatePasien(String nama, int usia, String alamat, Pasien newData) {
        Node curNode = HEAD;
        boolean ditemukan = false;
        while (curNode != null) {
            Pasien p = curNode.getData();
            if (p.getNama().equalsIgnoreCase(nama) && p.getUsia() == usia && p.getAlamat().equalsIgnoreCase(alamat)) {
                p.setNama(newData.getNama());
                p.setTanggalLahir(newData.getTanggalLahir());
                p.setJenisKelamin(newData.getJenisKelamin());
                p.setUsia(newData.getUsia());
                p.setNomorTelepon(newData.getNomorTelepon());
                p.setAlamat(newData.getAlamat());
                p.setTanggalKunjungan(newData.getTanggalKunjungan());
                p.setKeluhan(newData.getKeluhan());

                System.out.println("Pasien dengan nama: " + nama + " berhasil diupdate.");
                ditemukan = true;
                simpanUlangFile();
                break;
            }
            curNode = curNode.getNext();
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    public static void tampilkanMenu() {
        System.out.println("\n=== MENU KLINIK PASIEN ===");
        System.out.println("1. Tambah Pasien");
        System.out.println("2. Tampilkan Semua Pasien");
        System.out.println("3. Hapus Pasien");
        System.out.println("4. Update Data Pasien");
        System.out.println("5. Cari Pasien");
        System.out.println("6. Hitung Jumlah Pasien");
        System.out.println("0. Keluar");
        System.out.print("Pilihan Anda: ");
    }

    public void displayElement() {
        if (isEmpty()) {
            System.out.println("List Kosong");
        } else {
            Node curNode = HEAD;
            while (curNode != null) {
                System.out.println(curNode.getData());
                curNode = curNode.getNext();
            }
        }
        System.out.println();
    }
}
