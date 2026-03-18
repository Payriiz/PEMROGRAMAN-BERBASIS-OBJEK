public class mahasiswa {
    int nim;
    String nama;
    int nilai;

    mahasiswa(int nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getInfo() {
        return "NIM: " + nim + "\n" +
                "Nama: " + nama + "\n" +
                "Nilai: " + nilai;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;
    }
}
