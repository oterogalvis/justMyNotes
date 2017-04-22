package example10.com.treehouse.model;

import java.io.*;
import java.util.*;

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

    private Map<String, List<Song>> byArtist() {
        Map<String, List<Song>> byArtist = new TreeMap<>();
        for (Song song : songs) {
            List<Song> artistSongs = byArtist.get(song.getArtist());
            if (artistSongs == null) {
                artistSongs = new ArrayList<>();
                byArtist.put(song.getArtist(), artistSongs);
            }
            artistSongs.add(song);
        }
        return byArtist;
    }

    public Set<String> getArtists() {
        return byArtist().keySet();
    }

    public List<Song> getSongsForArtist(String artistName) {
        List<Song> songs = byArtist().get(artistName);
        songs.sort(new Comparator<Song>() {

            @Override
            public int compare(Song o1, Song o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.title.compareTo(o2.title);
            }

        });
        return songs;
    }

    public void exportTo(String fileName) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                PrintWriter printWriter = new PrintWriter(fileOutputStream);
        ) {
            for (Song song : songs) {
                printWriter.printf("%s|%s|%s%n", song.getArtist(), song.getTitle(), song.getVideoUrl());
            }
        } catch (IOException ioe) {
            System.out.printf("Problem saving %s %n", fileName);
            ioe.printStackTrace();
        }
    }

    public void importFrom(String fileName) {
        try (
                FileInputStream fileInputStream = new FileInputStream(fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] args = line.split("\\|");
                addSong(new Song(args[0], args[1], args[2]));
            }
        } catch (IOException ioe) {
            System.out.printf("Problem loading %s %n", fileName);
            ioe.printStackTrace();
        }
    }
}
