import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowData1 {

    static final String jdbc = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/toko_retail";
    static String username = "root";
    static String password = "";

    static Connection conn;
    static ResultSet rs;
    static Statement state;

    public static void main(String[] args) {

        try {
            Class.forName(jdbc);
            conn = DriverManager.getConnection(url, username, password);

            String query = "select * from tbl_barang";
            state = conn.createStatement();
            rs = state.executeQuery(query);

            System.out.println("\n=======================================================");
            System.out.println("               DAFTAR BARANG TOKO RETAIL               ");
            System.out.println("=======================================================");
            System.out.printf("| %-3s | %-6s | %-20s | %-7s | %-5s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
            System.out.println("-------------------------------------------------------");

            int nomor = 0;

            while (rs.next()) {
                nomor++;
                System.out.printf("| %-3d | %-6s | %-20s | %-7d | %-5d |\n",
                        nomor,
                        rs.getString("kode_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga_barang"),
                        rs.getInt("stok_barang"));
            }
            System.out.println("=======================================================");
            System.out.println("Total: " + nomor + " barang");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}