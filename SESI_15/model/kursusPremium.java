package model;

public class kursusPremium extends kursus {
    public kursusPremium() {
        super();
    }

    public kursusPremium(int id_kursus, String nama_kursus, String kategori, int slot) {
        super(id_kursus, nama_kursus, kategori, slot);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Informasi Kursus Premium ===");
        super.tampilkanInfo();
    }
}
