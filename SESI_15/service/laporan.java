package service;

import database.databaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class laporan {
    // Laporan Peserta (VIEW)
    public static void lihatPesertaTerdaftar() {

        try (Connection con = databaseManager.getConnection()) {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM v_peserta_terdaftar");

            System.out.println("\n==============================================");
            System.out.println("      DATA PESERTA TERDAFTAR");
            System.out.println("==============================================");

            boolean adaData = false;

            while (rs.next()) {

                adaData = true;

                System.out.println(
                        "ID Pendaftaran : " + rs.getInt("id_pendaftaran"));

                System.out.println(
                        "Nama Peserta   : " + rs.getString("nama_peserta"));

                System.out.println(
                        "Nama Kursus    : " + rs.getString("nama_kursus"));

                System.out.println(
                        "Kategori       : " + rs.getString("kategori"));

                System.out.println(
                        "Tanggal Daftar : " + rs.getTimestamp("tanggal_daftar"));

                System.out.println("----------------------------------------------");
            }

            if (!adaData) {
                System.out.println("Belum ada peserta yang terdaftar.");
            }

        } catch (Exception e) {

            System.out.println("Gagal menampilkan laporan.");
            System.out.println(e.getMessage());

        }

    }

    // Function
    public static void lihatSlotTersedia() {

        try (Connection con = databaseManager.getConnection()) {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT jumlah_slot() AS total_slot");

            if (rs.next()) {

                int totalSlot = rs.getInt("total_slot");

                System.out.println("\n=================================");
                System.out.println("TOTAL SLOT TERSEDIA");
                System.out.println("=================================");

                if (totalSlot == 0) {
                    System.out.println("Belum ada kursus atau seluruh slot telah habis.");
                } else {
                    System.out.println("Jumlah Slot : " + totalSlot);
                }

            } else {
                System.out.println("Data slot tidak tersedia.");
            }

        } catch (Exception e) {

            System.out.println("Gagal mengambil data.");
            System.out.println(e.getMessage());

        }

    }
}
