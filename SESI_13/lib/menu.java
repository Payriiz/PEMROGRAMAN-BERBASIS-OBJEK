import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean jalan = true;

        while (jalan) {
            System.out.println("\n====================");
            System.out.println("   MENU TOKO RETAIL");
            System.out.println("====================");
            System.out.println("1. Tampil Semua Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("0. Keluar");
            System.out.print("Masukkan Pilihan: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    ShowData1.main(null);
                    break;
                case 2:
                    Insert.main(null);
                    break;
                case 3:
                    Search.main(null);
                    break;
                case 4:
                    Update.main(null);
                    break;
                case 5:
                    Delete.main(null);
                    break;
                case 0:
                    jalan = false;
                    System.out.println("Keluar Dari Menu...");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!!");
            }
        }
        input.close();
    }
}
