import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
    static final String jdbc = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/toko_retail";
    static final String username = "root";
    static final String password = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Kode Barang yang mau diubah: ");
        String kode_barang = sc.nextLine();

        System.out.print("Nama Barang Baru: ");
        String nama_barang = sc.nextLine();

        System.out.print("Harga Barang Baru: ");
        int harga_barang = Integer.parseInt(sc.nextLine());

        System.out.print("Stok Barang Baru: ");
        int stok_barang = Integer.parseInt(sc.nextLine());

        String query = "UPDATE tbl_barang SET nama_barang=?, harga_barang=?, stok_barang=? WHERE kode_barang=?";

        try {
            Class.forName(jdbc);
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(query);

            // Set isi dari parameter '?' di query
            ps.setString(1, nama_barang);
            ps.setInt(2, harga_barang);
            ps.setInt(3, stok_barang);
            ps.setString(4, kode_barang);

            // Cek apakah ada baris yang berhasil diupdate
            if (ps.executeUpdate() > 0) {
                System.out.println("Data berhasil diupdate");
            } else {
                System.out.println("Data gagal diupdate. Kode Barang tidak ditemukan!");
            }

            // Tutup koneksi biar aman
            ps.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}