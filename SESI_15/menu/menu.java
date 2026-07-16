package menu;
import java.util.Scanner;
import service.kelolaKursus;
import service.kelolaPeserta;
import service.laporan;

public class menu {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean jalan = true;

        while (jalan) {

            System.out.println("\n================================");
            System.out.println(" SISTEM MANAJEMEN KURSUS ONLINE");
            System.out.println("================================");
            System.out.println("1. Kelola Kursus");
            System.out.println("2. Kelola Peserta");
            System.out.println("3. Laporan");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");

            int pilih = Integer.parseInt(input.nextLine());

            switch (pilih) {

                case 1:
                    menuKursus();
                    break;

                case 2:
                    menuPeserta();
                    break;

                case 3:
                    menuLaporan();
                    break;

                case 0:
                    jalan = false;
                    System.out.println("Program selesai...");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }

        input.close();
    }

    // MENU KURSUS

    public static void menuKursus() {

        System.out.println("\n===== KELOLA KURSUS =====");
        System.out.println("1. Tambah Kursus");
        System.out.println("2. Lihat Daftar Kursus");
        System.out.println("0. Kembali");
        System.out.print("Pilih : ");

        int pilih = Integer.parseInt(input.nextLine());

        switch (pilih) {

            case 1:
                kelolaKursus.tambahKursus();
                break;

            case 2:
                kelolaKursus.lihatKursus();
                break;

            case 0:
                break;

            default:
                System.out.println("Menu tidak tersedia.");
        }
    }

    // MENU PESERTA

    public static void menuPeserta() {

        System.out.println("\n===== KELOLA PESERTA =====");
        System.out.println("1. Daftar Kursus");
        System.out.println("2. Batalkan Pendaftaran");
        System.out.println("0. Kembali");
        System.out.print("Pilih : ");

        int pilih = Integer.parseInt(input.nextLine());

        switch (pilih) {

            case 1:
                kelolaPeserta.daftarKursus();
                break;

            case 2:
                kelolaPeserta.batalkanPendaftaran();
                break;

            case 0:
                break;

            default:
                System.out.println("Menu tidak tersedia.");
        }
    }

    // MENU LAPORAN

    public static void menuLaporan() {

        System.out.println("\n===== LAPORAN =====");
        System.out.println("1. Lihat Peserta Terdaftar");
        System.out.println("2. Lihat Total Slot Tersedia");
        System.out.println("0. Kembali");
        System.out.print("Pilih : ");

        int pilih = Integer.parseInt(input.nextLine());

        switch (pilih) {

            case 1:
                laporan.lihatPesertaTerdaftar();
                break;

            case 2:
                laporan.lihatSlotTersedia();
                break;

            case 0:
                break;

            default:
                System.out.println("Menu tidak tersedia.");
        }
    }
}