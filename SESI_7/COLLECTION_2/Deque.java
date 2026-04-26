import java.util.ArrayDeque;

public class Deque {
    public static void main(String[] args) {
        ArrayDeque<String> playlist = new ArrayDeque<>();
        playlist.offer("Arash Buana");
        playlist.offer("Kasper");
        playlist.offer("Gangga");
        playlist.offer("Reality Club");
        playlist.offer("Dhika Fawaz");

        System.out.println("Daftar Playlist Saat Ini: " + playlist);
        System.out.println("Artis Paling Atas: " + playlist.peek());
        String play = playlist.poll();
        System.out.println(play + " Diputar dan Dihapus Dari Daftar Playlist");
        System.out.println("Sisa Daftar Playlist Saat Ini: " + playlist);
    }
}
