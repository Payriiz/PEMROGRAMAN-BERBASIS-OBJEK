package SESI_7.PROJECT_3;
import java.util.ArrayList;

// inheritance + generic + implements
public class album<T> extends media implements playable {
    private T albumID; 
    private String genre;
    private ArrayList<lagu> trackList;

    public album(T albumID, String judul, String penyanyi, int tahun, String genre) {
        super(judul, penyanyi, tahun);
        this.albumID = albumID;
        this.genre = genre;
        this.trackList = new ArrayList<>();
    }

    public T getAlbumID() {
        return albumID;
    }

    public String getGenre() {
        return genre;
    }

    public void tambahLagu(lagu lagu) {
        trackList.add(lagu);
    }

    public int getTotalDurasi() {
        int total = 0;
        for (lagu s : trackList) total += s.getDurasi();
        return total;
    }

    @Override
    public void play() {
         System.out.println("Memutar Album: \"" + getJudul() + "\" by " + getPenyanyi());
    }

    @Override
    public void tampilTrackList() {
        System.out.println("Tracklist \"" + getJudul() + "\" (" + getTahun() + "):");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + trackList.get(i).getJudulLagu() + " [" + trackList.get(i).getFormatDurasi() + "]");
        }
        int totalMenit = getTotalDurasi() /60;
        System.out.println("  Total Durasi: " + totalMenit + " Menit");
    }


    @Override
    public String getDetail(){
        return "[Album] ID: " + albumID
        + " | " + getJudul()
        + " - " + getPenyanyi()
        + " (" + getTahun() + ")"
        + " | Genre: " + genre
        + " | " + trackList.size() + " lagu";
        }
}
