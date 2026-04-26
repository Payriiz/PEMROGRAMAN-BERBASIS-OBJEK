package SESI_7.PROJECT_3;

// Class dan Object
public class lagu {
    private String judulLagu;
    private String penyanyi;
    private int durasi;

    public lagu(String judulLagu, String penyanyi, int durasi) {
        this.judulLagu = judulLagu;
        this.penyanyi = penyanyi;
        this.durasi = durasi;
    }

    public String getJudulLagu() {
        return judulLagu;
    }

    public String getPenyanyi()  {
        return penyanyi;
    }

    public int getDurasi() {
        return durasi;
    }

    public String getFormatDurasi() {
        int menit = durasi / 60;
        int detik = durasi % 60;
        return String.format("%d:%2d", menit, detik);
    }

    @Override
    public String toString() {
        return "  - " + judulLagu + " (" + getFormatDurasi() + ") by " + penyanyi;
    }

}
