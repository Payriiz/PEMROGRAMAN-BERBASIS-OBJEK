public class rerata {
    public double hitungRataRata(grade[] dataMhs) {
        if (dataMhs.length == 0) return 0;
        
        double total = 0;
        for (int i = 0; i < dataMhs.length; i++) {
            total += dataMhs[i].getNilai(); 
        }
        return total / dataMhs.length;
    }

    public String buatDeretNilai(grade[] dataMhs) {
        String deret = "";
        for (int i = 0; i < dataMhs.length; i++) {
            if (i == 0) {
                deret += dataMhs[i].getNilai();
            } else {
                deret += "+" + dataMhs[i].getNilai();
            }
        }
        return deret;
    }
}