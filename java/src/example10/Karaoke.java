package example10;

import example10.com.treehouse.KaraokeMachine;
import example10.com.treehouse.model.SongBook;

/**
 * Created by jorgeotero on 3/29/17.
 */
public class Karaoke {
    public static void main(String[] args) {
        String songsFileLocation = "src/example10/";
        SongBook songBook = new SongBook();
        songBook.importFrom(songsFileLocation + "songs.txt");
        KaraokeMachine machine = new KaraokeMachine(songBook);
        machine.run();
        System.out.println("Saving book...");
        songBook.exportTo(songsFileLocation + "songs.txt");
    }
}