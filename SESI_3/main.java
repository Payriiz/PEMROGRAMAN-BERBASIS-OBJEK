import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mahasiswa yang akan diinput: ");
        int jml = input.nextInt();
        
        grade[] dataMhs = new grade[jml];

        for (int i = 0; i < jml; i++) {
            System.out.println("\n--- Data Mahasiswa ke-" + (i + 1) + " ---");
            
            System.out.print("NIM   : ");
            int nim = input.nextInt();
            input.nextLine();
            
            System.out.print("Nama  : ");
            String nama = input.nextLine();

            int nilai = 0;
            boolean valid = false;

            while (!valid) {
                System.out.print("Nilai : ");
                nilai = input.nextInt();
                if (nilai >= 0 && nilai <= 100) {
                    valid = true;
                } else {
                    System.out.println("Input nilai anda salah!");
                }
            }

            dataMhs[i] = new grade(nim, nama, nilai);
        }

        System.out.println("\n==================================================");

        int lulus = 0, tidakLulus = 0;
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeE = 0;
        String namaLulus = "", namaTidakLulus = "";
        String namaA = "", namaB = "", namaC = "", namaD = "", namaE = "";

        for (int i = 0; i < jml; i++) {
            System.out.println(dataMhs[i].getInfo());
            System.out.println("==================================================");

            int n = dataMhs[i].getNilai();
            String nm = dataMhs[i].getNama();
            String h = dataMhs[i].hurufMutu;

            if (dataMhs[i].lulus(n)) {
                lulus++;
                if (lulus == 1) namaLulus = nm; else namaLulus += ", " + nm;
            } else {
                tidakLulus++;
                if (tidakLulus == 1) namaTidakLulus = nm; else namaTidakLulus += ", " + nm;
            }

            if (h.equals("A")) { gradeA++; if (gradeA == 1) namaA = nm; else namaA += ", " + nm; }
            else if (h.equals("B")) { gradeB++; if (gradeB == 1) namaB = nm; else namaB += ", " + nm; }
            else if (h.equals("C")) { gradeC++; if (gradeC == 1) namaC = nm; else namaC += ", " + nm; }
            else if (h.equals("D")) { gradeD++; if (gradeD == 1) namaD = nm; else namaD += ", " + nm; }
            else if (h.equals("E")) { gradeE++; if (gradeE == 1) namaE = nm; else namaE += ", " + nm; }
        }

        System.out.println("Jumlah Mahasiswa : " + jml);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + (lulus > 0 ? " yaitu " + namaLulus : ""));
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + (tidakLulus > 0 ? " yaitu " + namaTidakLulus : ""));
        
        if (gradeA > 0) System.out.println("Jumlah Mahasiswa dengan Nilai A = " + gradeA + " yaitu " + namaA);
        if (gradeB > 0) System.out.println("Jumlah Mahasiswa dengan Nilai B = " + gradeB + " yaitu " + namaB);
        if (gradeC > 0) System.out.println("Jumlah Mahasiswa dengan Nilai C = " + gradeC + " yaitu " + namaC);
        if (gradeD > 0) System.out.println("Jumlah Mahasiswa dengan Nilai D = " + gradeD + " yaitu " + namaD);
        if (gradeE > 0) System.out.println("Jumlah Mahasiswa dengan Nilai E = " + gradeE + " yaitu " + namaE);

        rerata hitung = new rerata();
        String deret = hitung.buatDeretNilai(dataMhs);
        double hasilRata = hitung.hitungRataRata(dataMhs);
        
        System.out.println("Rata-rata nilai mahasiswa adalah : " + deret + " / " + jml + " = " + hasilRata);
    }
}