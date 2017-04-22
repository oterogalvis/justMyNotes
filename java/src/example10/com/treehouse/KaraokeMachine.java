package example10.com.treehouse;

import example10.com.treehouse.model.Song;
import example10.com.treehouse.model.SongBook;
import example10.com.treehouse.model.SongRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jorgeotero on 4/3/17.
 */
public class KaraokeMachine {
    private SongBook songBook;
    private BufferedReader bufferedReader;
    private Queue<SongRequest> songRequestQueue;
    private Map<String, String> menu;

    public KaraokeMachine(SongBook songBook) {
        this.songBook = songBook;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        songRequestQueue = new ArrayDeque<>();
        menu = new HashMap<String, String>();
        menu.put("add", "Add a new song to the song book.");
        menu.put("choose", "Choose a song to sing!");
        menu.put("play", "Play next song in the queue.");
        menu.put("quit", "Give up. Exit the program.");
    }

    private String promptAction() throws IOException {
        System.out.printf("There are %s songs available and %d in the queue. Your options are: %n", songBook.getSongCount(), songRequestQueue.size());
        for (Map.Entry<String, String> option : menu.entrySet()) {
            System.out.printf("%s - %s%n", option.getKey(), option.getValue());
        }
        System.out.printf("What do u want to do: ");
        String choice = bufferedReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run() {
        String choice = "";
        while (!choice.equals("quit")) {
            try {
                choice = promptAction();
                switch (choice) {
                    case "add":
                        Song song = promptNewSong();
                        songBook.addSong(song);
                        System.out.printf("%s added! %n%n", song);
                        break;
                    case "choose":
                        String singerName = promptForSingerName();
                        String artist = promptArtist();
                        Song artistSong = promptSongForArtist(artist);
                        SongRequest songRequest = new SongRequest(singerName, artistSong);
                        if (songRequestQueue.contains(songRequest)) {
                            System.out.printf("\n\nThe %s already requested %s!\n", singerName, artistSong);
                            break;
                        }
                        songRequestQueue.add(songRequest);
                        System.out.printf("You chose: %s%n", artistSong);
                        break;
                    case "play":
                        playNext();
                        break;
                    case "quit":
                        System.out.println("Thanks for playing.");
                        break;
                    default:
                        System.out.printf("Unknown choice: '%s'. Try again. %n%n%n", choice);
                }
            } catch (IOException ioe) {
                System.out.println("Problem with input");
                ioe.printStackTrace();
            }
        }
    }

    private String promptForSingerName() throws IOException {
        System.out.print("Enter the singer's name: ");
        return bufferedReader.readLine();
    }

    private Song promptNewSong() throws IOException {
        System.out.println("Enter the artist name: ");
        String artist = bufferedReader.readLine();
        System.out.println("Enter the title: ");
        String title = bufferedReader.readLine();
        System.out.println("Enter the video URL: ");
        String videoUrl = bufferedReader.readLine();
        return new Song(artist, title, videoUrl);
    }

    private String promptArtist() throws IOException {
        System.out.println("Available artists:");
        List<String> artists = new ArrayList<>(songBook.getArtists());
        int index = promptForIndex(artists);
        return artists.get(index);
    }

    private Song promptSongForArtist(String artist) throws IOException {
        List<Song> songs = songBook.getSongsForArtist(artist);
        List<String> songTitles = new ArrayList<>();
        for (Song song : songs) {
            songTitles.add(song.getTitle());
        }
        System.out.printf("Available songs for %s: %n", artist);
        int index = promptForIndex(songTitles);
        return songs.get(index);
    }

    private int promptForIndex(List<String> options) throws IOException {
        int counter = 1;
        for (String option : options) {
            System.out.printf("%d.)  %s %n", counter, option);
            counter++;
        }
        System.out.println("Your choice:    ");
        String optionAsString = bufferedReader.readLine();
        int choice = Integer.parseInt(optionAsString.trim());
        return choice - 1;
    }

    public void playNext() {
        SongRequest songRequest = songRequestQueue.poll();
        if (songRequest == null) {
            System.out.println("Sorry there is no songs in the queue. Use choose from the menu to add some.");
        } else {
            Song song = songRequest.getSong();
            System.out.printf("%n%n%n Open %s to hear the %s by %s %n%n%n",
                    songRequest.getSingerName(),
                    song.getVideoUrl(),
                    song.getTitle(),
                    song.getArtist());
        }
    }
}
