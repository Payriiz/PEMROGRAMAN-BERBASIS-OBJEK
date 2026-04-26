package SESI_7.PROJECT_3;

// Enkapsulasi
public abstract class media {
    private String judul;
    private String penyanyi;
    private int tahun;

    public media(String judul, String penyanyi, int tahun) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.tahun = tahun;
    }

    public String getJudul(){
        return judul;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public int getTahun() {
        return tahun;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public abstract String getDetail();
}
