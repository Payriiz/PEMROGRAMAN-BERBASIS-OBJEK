package CODINGAN.SESI_10;

public class Exception5 {
    public static void main(String[] args) {
        int bil = 10;
        try {
            System.out.println(bil / 0);
        } catch (ArithmeticException e) {
            System.out.println("Pesan Error: ");
            System.out.println(e.getMessage());
            System.out.println("Info Stack erase");
            e.printStackTrace();
            e.printStackTrace(System.out);
            System.out.println("TIDAK BISA DIBAGI NOL.");
        } catch (Exception e) {
            System.out.println("Ini Menghandle Error yang terjadi karena kesalahan umum.");
        }
    }
}
