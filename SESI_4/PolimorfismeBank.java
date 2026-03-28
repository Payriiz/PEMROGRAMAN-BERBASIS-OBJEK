class Bank {
    public int biayaTransfer(String bankTujuan) {
        switch (bankTujuan.toLowerCase()) {
            case "bni": return 3500;
            case "bca": return 4000;
            case "sama": return 0;
            default: return 5000;
        }
    }

    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah + "| dengan Nomor Rekening: " + rekeningTujuan + "| Bank Tujuan: (Sama)" + "| Biaya Transfer: " + biayaTransfer("sama"));
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah + "| dengan Nomor Rekening: " + rekeningTujuan + "| Bank Tujuan: " + bankTujuan.toUpperCase() + "| Biaya Transfer: " + biayaTransfer(bankTujuan));
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah + "| dengan Nomor Rekening: " + rekeningTujuan + "| Bank Tujuan: " + bankTujuan.toUpperCase() + "| Berita: " + berita + "| Biaya Transfer: " + biayaTransfer(bankTujuan));
    }
}

class BankBNI extends Bank {
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        super.transferUang(jumlah, rekeningTujuan, "BNI");
    }
}

class BankBCA extends Bank {
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        super.transferUang(jumlah, rekeningTujuan, "BCA");
    }
}

public class PolimorfismeBank {
    public static void main(String[] args) {
        System.out.println("=== OVERRIDING ===");
        System.out.println("Memanggil sukuBunga() dari masing-masing objek\n");

        Bank b1 = new Bank();
        Bank b2 = new BankBNI();
        Bank b3 = new BankBCA();

        b1.sukuBunga();
        b2.sukuBunga();
        b3.sukuBunga();

        System.out.println("\n=== OVERLOADING ===");
        System.out.println("Memanggil transferUang() dengan argumen berbeda\n");

        b1.transferUang(50000, "910293810011");
        b1.transferUang(800000, "12837123618", "bri");
        b1.transferUang(900000, "237126876312", "bca", "bayar cicilan BMW");

        System.out.println("\n=== OVERRIDING ===");
        b2.transferUang(100000, "112233", "mandiri");
        b3.transferUang(200000, "445566", "bri");
    }
}