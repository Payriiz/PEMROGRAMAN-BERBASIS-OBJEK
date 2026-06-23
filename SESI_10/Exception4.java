package CODINGAN.SESI_10;

public class Exception4 {
    public static void main(String[] args) {
        int bil = 10;
        String b[] = {"a", "b", "c"};
        try {
            int hasil = bil / 0;
            System.out.println(b[3]);
        } catch (ArithmeticException e) {
            System.out.println("Terjadi Aritmatika Error.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Melebihi Jumlah Array.");
        } catch (Exception e) {
            System.out.println("Ini Menghandle Error yang terjadi karena kesalahan umum.");
        }
    }
}
