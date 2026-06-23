package CODINGAN.SESI_10;

public class Exception3 {
    public static void main(String[] args) {
        int bil = 10;
        try {
            int hasil = bil / 0;
        } catch (ArithmeticException e) {
            System.out.println("Terjadi Aritmatika Error.");
        } catch (Exception e) {
            System.out.println("Ini Menghandle Error yang terjadi karena kesalahan umum.");
        }
    }
}
