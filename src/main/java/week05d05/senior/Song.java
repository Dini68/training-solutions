package week05d05.senior;

public class Song {

    private String name;

    private long lengthInSeconds;

    private String artist;

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    public Song(String name, long lengthInSeconds, String artist) {
        if (name.isBlank() || artist.isBlank()) {
            throw new IllegalArgumentException("param is empty");
        }
        if (lengthInSeconds < 0) {
            throw new IllegalArgumentException("invalid param" + lengthInSeconds);
        }

        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", lengthInSeconds=" + lengthInSeconds +
                ", artist='" + artist + '\'' +
                '}';
    }
}
