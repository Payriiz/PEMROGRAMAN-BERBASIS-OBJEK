package SESI_7.PROJECT_3;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;

public class main {
    public static void main(String[] args) {
        System.out.println("===== ALBUM & PLAYLIST IBNU FARIZ FAUZAN HAMZAH =====");

        // Class dan Objek
        lagu arash1 = new lagu("April", "Arash Buana", 214);
        lagu arash2 = new lagu("Stars", "Arash Buana", 243);
        lagu arash3 = new lagu("Depressed Sometimes", "Arash Buana", 228);

        lagu chrisye1 = new lagu("Kisah Cintaku", "Chrisye", 350);
        lagu chrisye2 = new lagu("Pergilah Kasih", "Chrisye", 281);
        lagu chrisye3 = new lagu("Andai Aku Bisa", "Chrisye", 224);

        lagu kerispatih1 = new lagu("Tertatih", "Kerispatih", 211);
        lagu kerispatih2 = new lagu("Tapi Bukan Aku", "Kerispatih", 293);
        lagu kerispatih3 = new lagu("Aku Harus Jujur", "Kerispatih", 255);

        // Generic
        album<String> albumArash = new album<>("AB-0607", "Stars", "Arash Buana", 2021, "Pop Indonesia");
        albumArash.tambahLagu(arash1);
        albumArash.tambahLagu(arash2);
        albumArash.tambahLagu(arash3);

        album<String> albumChrisye = new album<>("AB-2508", "Jujur", "Chrisye", 1999, "Pop Indonesia");
        albumChrisye.tambahLagu(chrisye1);
        albumChrisye.tambahLagu(chrisye2);
        albumChrisye.tambahLagu(chrisye3);

        album<String> albumKerispatih = new album<>("AB-2506", "Kangen", "Kerispatih", 2019, "Pop Indonesia");
        albumKerispatih.tambahLagu(kerispatih1);
        albumKerispatih.tambahLagu(kerispatih2);
        albumKerispatih.tambahLagu(kerispatih3);

        // Collection
        System.out.println("KOLEKSI ALBUM DALAM PLAYLIST\n");
        ArrayList<album<String>> koleksiAlbum = new ArrayList<>();
        koleksiAlbum.add(albumArash);
        koleksiAlbum.add(albumChrisye);
        koleksiAlbum.add(albumKerispatih);

        // Polimorfisme
        ArrayList<media> semuaMedia = new ArrayList<>();
        semuaMedia.add(albumArash);
        semuaMedia.add(albumChrisye);
        semuaMedia.add(albumKerispatih);
 
        for (media m : semuaMedia) {
            System.out.println(m.getDetail()); // Polimorfisme
        }

        System.out.println("\nTRACKLIST ALBUM\n");
        for (album<String> a : koleksiAlbum) {
            a.play();
            a.tampilTrackList();
            System.out.println();
        }

        System.out.println("PLAYLIST MELAMUN\n");
        playlist playlist = new playlist("Playlist Melamun", "Ibnu Fariz Fauzan Hamzah");
        playlist.menambahAntrian(arash1);
        playlist.menambahAntrian(chrisye1);
        playlist.menambahAntrian(kerispatih1);
        playlist.menambahAntrian(arash2);
        playlist.menambahAntrian(arash3);
 
        System.out.println();
        playlist.tampilTrackList();
 
        System.out.println("\nMulai putar playlist:\n");
        while (playlist.totalLagu() > 0) {
            playlist.play();
        }
        System.out.println("\nPlaylist selesai!");
        System.out.println("===== Program Selesai =====");
    }    
}
