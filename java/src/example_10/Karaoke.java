package example_10;

import example_10.com.treehouse.KareokeMachine;
import example_10.com.treehouse.model.SongBook;

/**
 * Created by jorgeotero on 3/29/17.
 */
public class Karaoke {
    public static void main(String[] args) {
        String songsFileLocation = "src/example_10/";
        SongBook songBook = new SongBook();
        songBook.importFrom(songsFileLocation + "songs.txt");
        KareokeMachine machine = new KareokeMachine(songBook);
        machine.run();
        System.out.println("Saving book...");
        songBook.exportTo(songsFileLocation + "songs.txt");
    }
}