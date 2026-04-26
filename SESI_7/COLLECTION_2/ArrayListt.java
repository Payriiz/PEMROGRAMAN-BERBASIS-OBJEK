import java.util.ArrayList;

public class ArrayListt {
    public static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("LANY");
        playlist.add("Oasis");
        playlist.add("Arash Buana");
        playlist.add("Kasper");
        System.out.println("Playlist Teratas: " + playlist);
        System.out.println("Akan Memutar Lagu Dari: " + playlist.get(1));
        playlist.remove(3);
        System.out.println("Artis ada yang dihapus: " + playlist);
    }
}
