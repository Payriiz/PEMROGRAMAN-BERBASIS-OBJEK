package service;

import database.databaseManager;
import model.peserta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class kelolaPeserta {
    static Scanner input = new Scanner(System.in);

    // Daftar Kursus

    public static void daftarKursus() {

        try (Connection con = databaseManager.getConnection()) {

            peserta peserta = new peserta();

            System.out.println("\n=== PENDAFTARAN KURSUS ===");

            System.out.print("Nama Peserta : ");
            peserta.setNama_peserta(input.nextLine());

            System.out.print("Email        : ");
            peserta.setEmail(input.nextLine());

            String sqlPeserta =
                    "INSERT INTO peserta(nama_peserta,email) VALUES(?,?)";

            PreparedStatement psPeserta =
                    con.prepareStatement(sqlPeserta,
                            PreparedStatement.RETURN_GENERATED_KEYS);

            psPeserta.setString(1, peserta.getNama_peserta());
            psPeserta.setString(2, peserta.getEmail());

            psPeserta.executeUpdate();

            var rs = psPeserta.getGeneratedKeys();

            int idPeserta = 0;

            if (rs.next()) {
                idPeserta = rs.getInt(1);
            }

            System.out.print("ID Kursus yang dipilih : ");
            int idKursus = Integer.parseInt(input.nextLine());

            String sqlDaftar =
                    "INSERT INTO pendaftaran(id_peserta,id_kursus) VALUES(?,?)";

            PreparedStatement psDaftar =
                    con.prepareStatement(sqlDaftar);

            psDaftar.setInt(1, idPeserta);
            psDaftar.setInt(2, idKursus);

            psDaftar.executeUpdate();

            System.out.println("\nPendaftaran berhasil.");

        } catch (Exception e) {

            System.out.println("Pendaftaran gagal.");
            System.out.println(e.getMessage());

        }

    }

    // Batalkan Pendaftaran

    public static void batalkanPendaftaran() {

        try (Connection con = databaseManager.getConnection()) {

            System.out.println("\n=== BATALKAN PENDAFTARAN ===");

            System.out.print("ID Pendaftaran : ");

            int id =
                    Integer.parseInt(input.nextLine());

            String sql =
                    "DELETE FROM pendaftaran WHERE id_pendaftaran=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int hasil = ps.executeUpdate();

            if (hasil > 0) {

                System.out.println("Pendaftaran berhasil dibatalkan.");

            } else {

                System.out.println("ID Pendaftaran tidak ditemukan.");

            }

        } catch (Exception e) {

            System.out.println("Gagal membatalkan pendaftaran.");
            System.out.println(e.getMessage());

        }

    }
}
