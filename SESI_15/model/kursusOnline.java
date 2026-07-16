package model;

public class kursusOnline extends kursus {
    public kursusOnline() {
        super();
    }

    public kursusOnline(int id_kursus, String nama_kursus, String kategori, int slot) {
        super(id_kursus, nama_kursus, kategori, slot);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Informasi Kursus Online ===");
        super.tampilkanInfo();
    }
}
