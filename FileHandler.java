import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "dataBuku.txt";

    // Method untuk menyimpan daftar buku ke file
    public static void simpanKeFile(ArrayList<Buku> daftarBuku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Buku buku : daftarBuku) {
                writer.write(buku.formatUntukSimpan()); // Simpan data dalam format yang sesuai
                writer.newLine();
            }
            System.out.println("Data buku berhasil disimpan ke file.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data buku: " + e.getMessage());
        }
    }
}
