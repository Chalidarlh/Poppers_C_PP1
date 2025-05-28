package KlinikPasien;

import java.util.Scanner;

public class MenuProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ListPasien daftarPasien = new ListPasien();
        int pilihan;

        do {
            System.out.println("\n=== MENU KLINIK PASIEN ===");
            System.out.println("1. Tambah Pasien di Awal");
            System.out.println("2. Tambah Pasien di Tengah");
            System.out.println("3. Tambah Pasien di Akhir");
            System.out.println("4. Tampilkan Semua Pasien");
            System.out.println("5. Hapus Pasien di Awal");
            System.out.println("6. Hapus Pasien di Tengah");
            System.out.println("7. Hapus Pasien di Akhir");
            System.out.println("8. Update Data Pasien");
            System.out.println("9. Cari Pasien");
            System.out.println("10. Hitung Jumlah Pasien");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
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
                    boolean ditemukan = daftarPasien.find(namaCari);
                    if (ditemukan) {
                        System.out.println("Pasien ditemukan.");
                    } else {
                        System.out.println("Pasien tidak ditemukan.");
                    }
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

        System.out.print("Usia: ");
        int usia = input.nextInt();
        input.nextLine(); // clear newline

        System.out.print("Nomor Telepon: ");
        String noTelp = input.nextLine();

        System.out.print("Alamat: ");
        String alamat = input.nextLine();

        System.out.print("Tanggal Kunjungan (yyyy-mm-dd): ");
        String tglKunjungan = input.nextLine();

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

        return new Pasien(nama, jk, usia, noTelp, alamat, tglKunjungan, keluhan, status);
    }
}

