package model;

public class peserta {
    private int id_peserta;
    private String nama_peserta;
    private String email;
    
    public peserta() {
    }

    public peserta(int id_peserta, String nama_peserta, String email) {
        this.id_peserta = id_peserta;
        this.nama_peserta = nama_peserta;
        this.email = email;
    }

    public int getId_peserta() {
        return id_peserta;
    }

    public void setId_peserta(int id_peserta) {
        this.id_peserta = id_peserta;
    }

    public String getNama_peserta() {
        return nama_peserta;
    }

    public void setNama_peserta(String nama_peserta) {
        this.nama_peserta = nama_peserta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void tampilkanInfo() {
        System.out.println("ID Peserta: " + id_peserta);
        System.out.println("Nama Peserta: " + nama_peserta);
        System.out.println("Email: " + email);
    }
}
