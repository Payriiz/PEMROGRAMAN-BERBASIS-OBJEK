import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // DATA MAHASISWA/SISWA
        System.out.println("==== INPUT DATA MAHASISWA ====");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String mhs = input.nextLine();
        System.out.print("Masukkan Alamat Mahasiswa: ");
        String almt = input.nextLine();

        student siswa = new student(mhs, almt);

        System.out.print("Berapa Banyak Mata Kuliah yang Diambil: ");
        int matkul = input.nextInt();
        input.nextLine();

        for (int i = 0; i < matkul; i++) {
            System.out.println("\nData Mata Kuliah Ke-" + (i+1));
            System.out.print("Nama Mata Kuliah: ");
            String matkulNama = input.nextLine();
            System.out.print("Masukkan Nilai (0-100): ");
            int nilai = input.nextInt();
            input.nextLine();
            siswa.addCourseGrade(matkulNama, nilai);
        }

        System.out.println("\n==== HASIL DATA MAHASISWA ====");
        System.out.println(siswa.toString());
        siswa.printGrades();
        System.out.printf("Rata-rata nilai: %.2f\n", siswa.getAverageGrade());
        System.out.println("\n==============================\n");

        // DATA DOSEN/GURU
        System.out.println("==== INPUT DATA DOSEN ====");
        System.out.print("Masukkan Nama Dosen: ");
        String dsn = input.nextLine();
        System.out.print("Masukkan Alamat Dosen: ");
        String almtdsn = input.nextLine();

        teacher dosen = new teacher(dsn, almtdsn);

        System.out.print("Berapa Banyak Mata Kuliah yang Diambil Oleh Dosen: ");
        int matkuldsn = input.nextInt();
        input.nextLine();

        for (int i = 0; i < matkuldsn; i++) {
            System.out.print("\nData Mata Kuliah Ke-" + (i+1) + ": ");
            String mkdsn = input.nextLine();
            if (dosen.addCourses(mkdsn)) {
                System.out.println("BERHASIL DITAMBAHKAN!!!");
            } else {
                System.out.println("GAGAL DITAMBAHKAN!!! SUDAH ADA.");
            }
        }

        System.out.println("\n==== HASIL DATA DOSEN ====");
        System.out.println(dosen.toString());
        System.out.println("\n==============================\n");

        input.close();
    }
}
