public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    // Constructor
    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Overloading Method: tampilkanInfo()
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
    }

    public void tampilkanInfo(boolean detail) {
        if (detail) {
            System.out.println("Judul: " + judul);
            System.out.println("Penulis: " + penulis);
            System.out.println("Tahun Terbit: " + tahunTerbit);
        } else {
            tampilkanInfo(); // Memanggil metode tanpa parameter
        }
    }

    // Getter untuk menyimpan data ke file
    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }
}
