package CODINGAN.SESI_10;

public class ThrowExample {
    static void demo() {
        NullPointerException t;
        t = new NullPointerException("Coba Throw");
        throw t;
        // Baris ini tidak lagi dieksekusi karena exception sudah dilempar.
        // System.out.println("Baris ini tidak akan dieksekusi.");
    }

        public static void main(String[] args) {
            try {
                demo();
                System.out.println("Selesai");
            } catch (NullPointerException e) {
                System.out.println("Exception ditangkap: " + e.getMessage());
        
            }
    }
}

