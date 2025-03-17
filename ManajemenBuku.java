import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenBuku {
    private static final String FILE_NAME = "dataBuku.txt";
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();

    public static void main(String[] args) {
        bacaDataDariFile(); // Membaca data buku dari file saat program dimulai
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            // Menampilkan menu
            System.out.println("\nPilihan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Keluar");
            System.out.print("Opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    tambahBuku(scanner); // Menambah buku baru
                    break;
                case 2:
                    tampilkanDaftarBuku(scanner); // Menampilkan daftar buku
                    break;
                case 3:
                    simpanDataKeFile(); // Menyimpan data ke file sebelum keluar
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);

        scanner.close(); // Menutup Scanner
    }

    // Method untuk menambah buku
    private static void tambahBuku(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        Buku bukuBaru = new Buku(judul, penulis, tahunTerbit);
        daftarBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan!");
    }

    // Method untuk menampilkan daftar buku
    private static void tampilkanDaftarBuku(Scanner scanner) {
        System.out.println("\nPilihan Tampilan:");
        System.out.println("1. Tampilkan judul saja");
        System.out.println("2. Tampilkan detail lengkap");
        System.out.print("Opsi: ");
        int opsi = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        for (Buku buku : daftarBuku) {
            if (opsi == 1) {
                buku.tampilkanInfo(); // Menampilkan judul saja
            } else if (opsi == 2) {
                buku.tampilkanInfo(true); // Menampilkan detail lengkap
            }
            System.out.println(); // Spasi antar buku
        }
    }

    // Method untuk menyimpan data buku ke file
    private static void simpanDataKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Buku buku : daftarBuku) {
                writer.write(buku.getJudul() + "," + buku.getPenulis() + "," + buku.getTahunTerbit());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data ke file.");
        }
    }

    // Method untuk membaca data buku dari file
    private static void bacaDataDariFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String judul = data[0];
                    String penulis = data[1];
                    int tahunTerbit = Integer.parseInt(data[2]);
                    daftarBuku.add(new Buku(judul, penulis, tahunTerbit));
                }
            }
        } catch (IOException e) {
            System.out.println("File tidak ditemukan atau gagal membaca data.");
        }
    }
}
