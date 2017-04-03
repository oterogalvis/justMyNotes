package example_10.model;

import example_10.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgeotero on 3/29/17.
 */
public class SongBook {
    private List<Song> songs;

    public SongBook() {
        songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public int getSongCount() {
        return songs.size();
    }
}
