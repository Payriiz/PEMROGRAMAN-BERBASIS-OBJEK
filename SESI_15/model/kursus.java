package model;

public class kursus {
    private int id_kursus;
    private String nama_kursus;
    private String kategori;
    private int slot;

    public kursus() {
    }

    public kursus(int id_kursus, String nama_kursus, String kategori, int slot) {
        this.id_kursus = id_kursus;
        this.nama_kursus = nama_kursus;
        this.kategori = kategori;
        this.slot = slot;
    }

    public int getId_kursus() {
        return id_kursus;
    }

    public void setId_kursus(int id_kursus) {
        this.id_kursus = id_kursus;
    }

    public String getNama_kursus() {
        return nama_kursus;
    }

    public void setNama_kursus(String nama_kursus) {
        this.nama_kursus = nama_kursus;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void tampilkanInfo() {
        System.out.println("ID Kursus: " + id_kursus);
        System.out.println("Nama Kursus: " + nama_kursus);
        System.out.println("Kategori: " + kategori);
        System.out.println("Slot: " + slot);
    }
}
