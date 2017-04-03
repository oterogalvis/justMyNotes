package example_10;

import example_10.model.Song;
import example_10.model.SongBook;

/**
 * Created by jorgeotero on 3/29/17.
 */
public class Karaoke {
    public static void main(String[] args){
        Song song = new Song(
                "Dido",
                "Here with me",
                "https://www.youtube.com/watch?v=PSu5nAQ7uZw");
        SongBook songBook = new SongBook();
        System.out.printf("Adding song: %s.%n", song);
        songBook.addSong(song);
        System.out.printf("There are %s songs available", songBook.getSongCount());
    }
}
