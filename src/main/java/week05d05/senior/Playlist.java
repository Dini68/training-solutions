package week05d05.senior;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songs = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan (int mins) {
        List<Song> result = new ArrayList<>();
        for (Song s: songs) {
            if (s.getLengthInSeconds() / 60 > mins ) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(
                List.of(new Song("Szállj el kismadár", 300, "Republic"),
                        new Song("Kicsi vagyok", 200, "Republic"),
                        new Song("Dórácska áll", 400, "Republic")));
        System.out.println(playlist.findByLengthGreaterThan(4));
        System.out.println(playlist.findByLengthGreaterThan(5));

    }
}
