package SESI_2;

public class Handphone {
    String jenis_hp;
    int tahun_pembuatan;

    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    public String getJenisHP(){
        return jenis_hp;
    }

    public int getTahunPembuatan(){
        return tahun_pembuatan;
    }

    public static void main(String[] args) {
        Handphone hp = new Handphone();
        hp.setDataHP("Samsung", 1999);
        System.out.println("Merk Hp: " + hp.getJenisHP());
        System.out.println("Dibuat pada tahun: " + hp.getTahunPembuatan());
    }
}