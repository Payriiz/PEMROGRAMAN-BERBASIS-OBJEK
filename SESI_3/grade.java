public class grade extends mahasiswa {
    String hurufMutu;

    grade(int nim, String nama, int nilai) {
        super(nim, nama, nilai);
        this.hurufMutu = nilaiHuruf(nilai);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
                "Grade: " + hurufMutu;
    }

    public String nilaiHuruf(int nilai) {
        if (nilai >= 80 && nilai <= 100) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    public boolean lulus(int nilai) {
        return nilai >= 60;
    }
}