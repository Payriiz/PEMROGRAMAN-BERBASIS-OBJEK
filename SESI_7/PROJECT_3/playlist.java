package SESI_7.PROJECT_3;
import java.util.ArrayDeque;

public class playlist extends media implements playable{
    private ArrayDeque<lagu> queue; //ArrayDeque

    public playlist(String judul, String pemilik) {
        super(judul, pemilik, java.time.Year.now().getValue());
        this.queue = new ArrayDeque<>();
    }

    public void menambahAntrian(lagu lagu) {
        queue.addLast(lagu);
        System.out.println("  + \"" + lagu.getJudulLagu() + "\" Ditambahkan Ke Playlist.");
    }

    public lagu laguSelanjutnya() {
        return queue.pollFirst();
    }
    
    public lagu peekNext() {
        return queue.peekFirst();
    }

    public int totalLagu() {
        return queue.size();
    }
    
    @Override
    public void play() {
        if (queue.isEmpty()) {
            System.out.println("Playlist kosong!");
            return;
        }
        lagu current = laguSelanjutnya();
        System.out.println("Memutar: \"" + current.getJudulLagu()
                + "\" by " + current.getPenyanyi()
                + " [" + current.getFormatDurasi() + "]");
        if (!queue.isEmpty()) {
            System.out.println("  Next up: \"" + peekNext().getJudulLagu() + "\"");
        }
    }

    @Override
    public void tampilTrackList() {
        System.out.println("Playlist \"" + getJudul() + "\" (" + totalLagu() + " lagu):");
        int no = 1;
        for (lagu s : queue) {
            System.out.println("  " + no++ + ". " + s);
        }
    }

    // Polimorfisme
    @Override
    public String getDetail() {
        return "[Playlist] \"" + getJudul() + "\" by " + getPenyanyi()
                + " | " + totalLagu() + " lagu dalam antrian";
    }
}
