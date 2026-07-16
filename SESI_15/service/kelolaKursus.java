package service;

import database.databaseManager;
import model.kursus;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class kelolaKursus {
    static Scanner input = new Scanner(System.in);

    // Tambah Kursus (Procedure)

    public static void tambahKursus() {

        try (Connection con = databaseManager.getConnection()) {

            kursus kursus = new kursus();

            System.out.println("\n=== TAMBAH KURSUS ===");

            System.out.print("Nama Kursus     : ");
            kursus.setNama_kursus(input.nextLine());

            System.out.print("Kategori        : ");
            kursus.setKategori(input.nextLine());

            System.out.print("Slot Tersedia   : ");
            kursus.setSlot(Integer.parseInt(input.nextLine()));

            CallableStatement cs = con.prepareCall(
                    "{CALL tambah_kursus(?,?,?)}");

            cs.setString(1, kursus.getNama_kursus());
            cs.setString(2, kursus.getKategori());
            cs.setInt(3, kursus.getSlot());

            cs.execute();

            System.out.println("\nData kursus berhasil ditambahkan.");

        } catch (Exception e) {
            System.out.println("Gagal menambahkan kursus.");
            System.out.println(e.getMessage());
        }

    }

    // Lihat Semua Kursus

    public static void lihatKursus() {

        try (Connection con = databaseManager.getConnection()) {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM kursus");

            System.out.println("\n==============================================");
            System.out.println("           DAFTAR KURSUS");
            System.out.println("==============================================");

            while (rs.next()) {

                kursus kursus = new kursus();

                kursus.setId_kursus(rs.getInt("id_kursus"));
                kursus.setNama_kursus(rs.getString("nama_kursus"));
                kursus.setKategori(rs.getString("kategori"));
                kursus.setSlot(rs.getInt("slot_tersedia"));

                kursus.tampilkanInfo();

                System.out.println("----------------------------------------------");
            }

        } catch (Exception e) {

            System.out.println("Gagal menampilkan data.");
            System.out.println(e.getMessage());

        }

    }
}
