package example10.com.treehouse.model;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (artist != null ? !artist.equals(song.artist) : song.artist != null) return false;
        if (title != null ? !title.equals(song.title) : song.title != null) return false;
        return videoUrl != null ? videoUrl.equals(song.videoUrl) : song.videoUrl == null;

    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (videoUrl != null ? videoUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s by %s", title, artist);
    }
}
