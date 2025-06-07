package KlinikPasien;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import KlinikPasien.src.Entity.Pasien;
import KlinikPasien.src.Services.ListPasien;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ListPasien daftarPasien = new ListPasien();
        daftarPasien.loadFromFile();
        int pilihan;

        do {
            ListPasien.tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine(); // clear newline

            switch (pilihan) {
                case 1:
                    daftarPasien.addTail(buatPasien(input));
                    break;
                case 2:
                    daftarPasien.displayElement();
                    break;
                case 3:
                    System.out.print("Masukkan Nama Pasien yang akan dihapus: ");
                    String namaHapus = input.nextLine();
                    System.out.print("Usia: ");
                    int usiaHapus = input.nextInt();
                    input.nextLine();
                    System.out.print("Alamat: ");
                    String alamatHapus = input.nextLine();
                    daftarPasien.removeMid(namaHapus, usiaHapus, alamatHapus);
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang akan diupdate: ");
                    String namaUpdate = input.nextLine();
                    System.out.print("Usia: ");
                    int usiaUpdate = input.nextInt();
                    input.nextLine();
                    System.out.print("Alamat: ");
                    String alamatUpdate = input.nextLine();
                    System.out.println("Masukkan data pasien baru:");
                    Pasien dataBaru = buatPasien(input);
                    daftarPasien.updatePasien(namaUpdate, usiaUpdate, alamatUpdate, dataBaru);
                    break;
                case 5:
                    System.out.print("Masukkan Nama Pasien: ");
                    String namaCari = input.nextLine();
                    daftarPasien.find(namaCari);
                    break;
                case 6:
                    int jumlah = daftarPasien.count();
                    System.out.println("Jumlah pasien: " + jumlah);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        input.close();
    }

    private static Pasien buatPasien(Scanner input) {
        String nama;
        while (true) { 
        System.out.print("Nama: ");
        nama = input.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong. Silahkan masukkan nama yang valid"); 
            } else if (!nama.matches("[a-zA-Z\\s]+")) {
                System.out.println("Nama hanya boleh mengandung huruf dan spasi. Silahkan masukkan nama yang valid"); 
            } else {
                break;
            }
        } 


        String jk;
        while (true) {
            System.out.print("Jenis Kelamin (laki-laki/perempuan): ");
            jk = input.nextLine().toLowerCase();
            if (jk.equals("laki-laki") || jk.equals("perempuan")) {
                break;
            } else {
                System.out.println("Masukkan hanya 'laki-laki' atau 'perempuan'");
            }
        }

        LocalDate tanggalLahir = null;
        while (true) {
            try {
                System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
                tanggalLahir = LocalDate.parse(input.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal tidak valid. Contoh: 2001-12-25");
            }
        }

        int usia;
        while (true) {
            System.out.print("Usia: ");
            try {
                usia = Integer.parseInt(input.nextLine());
                if (usia < 0 || usia > 100) {
                    System.out.print("Usia tidak boleh 4 angka."); 
                } else {
                    break;
                }
            }catch (NumberFormatException e) {
                System.out.print("Usia harus berpa angka. Silahkan coba lagi. ");
            }
        }

        System.out.print("Nomor Telepon: ");
        String noTelp = input.nextLine();

        System.out.print("Alamat: ");
        String alamat = input.nextLine();

        LocalDate tanggalKunjungan = null;
        while (true) {
            try {
                System.out.print("Tanggal Kunjungan (yyyy-mm-dd): ");
                tanggalKunjungan = LocalDate.parse(input.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal tidak valid. Contoh: 2024-05-30");
            }
        }

        String keluhan;
        while (true) {
            System.out.print("Keluhan: ");
            keluhan = input.nextLine().trim();
            if (keluhan.isEmpty()) {
                System.out.println("keluhan tidak boleh kosong");
            } else {
                break;
            }
        }
        
        return new Pasien(nama, tanggalLahir, jk, usia, noTelp, alamat, tanggalKunjungan, keluhan);
    }
}
