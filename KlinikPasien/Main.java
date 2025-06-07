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
                    daftarPasien.addHead(buatPasien(input));
                    break;
                case 2:
                    System.out.print("Masukkan posisi: ");
                    int posisi = input.nextInt();
                    input.nextLine();
                    daftarPasien.addMid(buatPasien(input), posisi);
                    break;
                case 3:
                    daftarPasien.addTail(buatPasien(input));
                    break;
                case 4:
                    daftarPasien.displayElement();
                    break;
                case 5:
                    daftarPasien.removeHead();
                    break;
                case 6:
                    System.out.print("Masukkan Nama Pasien yang akan dihapus: ");
                    String namaHapus = input.nextLine();
                    System.out.print("Usia: ");
                    int usiaHapus = input.nextInt();
                    input.nextLine();
                    System.out.print("Alamat: ");
                    String alamatHapus = input.nextLine();
                    daftarPasien.removeMid(namaHapus, usiaHapus, alamatHapus);
                    break;
                case 7:
                    daftarPasien.removeTail();
                    break;
                case 8:
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
                case 9:
                    System.out.print("Masukkan Nama Pasien: ");
                    String namaCari = input.nextLine();
                    daftarPasien.find(namaCari);
                    break;
                case 10:
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
        System.out.print("Nama: ");
        String nama = input.nextLine();

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

        System.out.print("Usia: ");
        int usia = input.nextInt();
        input.nextLine(); // clear newline

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

        System.out.print("Keluhan: ");
        String keluhan = input.nextLine();

        String status;
        while (true) {
            System.out.print("Status Pasien (pasien baru/pasien lama): ");
            status = input.nextLine().toLowerCase();
            if (status.equals("pasien baru") || status.equals("pasien lama")) {
                break;
            } else {
                System.out.println("Masukkan hanya 'pasien baru' atau 'pasien lama'.");
            }
        }

        return new Pasien(nama, tanggalLahir, jk, usia, noTelp, alamat, tanggalKunjungan, keluhan);
    }
}
