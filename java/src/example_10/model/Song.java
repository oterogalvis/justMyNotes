package example_10.model;

/**
 * Created by jorgeotero on 3/29/17.
 */
public class Song {
    private String artist;
    private String title;
    private String videoUrl;

    public Song(String artist, String title, String videoUrl) {
        this.artist = artist;
        this.title = title;
        this.videoUrl = videoUrl;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    @Override
    public String toString() {
        return String.format("%s by %s", title, artist);
    }
}
