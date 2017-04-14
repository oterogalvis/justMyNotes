package example_10.com.treehouse.model;

/**
 * Created by jorgeotero on 3/29/17.
 */
public class Song {
    protected String artist;
    protected String title;
    protected String videoUrl;

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
