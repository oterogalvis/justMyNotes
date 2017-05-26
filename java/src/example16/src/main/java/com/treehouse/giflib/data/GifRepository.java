package com.treehouse.giflib.data;

import com.treehouse.giflib.Model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jorgeotero on 5/24/17.
 */

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 3, LocalDate.of(2015, 2, 13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", 2, LocalDate.of(2015, 10, 30), "Ben Jakuben", true),
            new Gif("book-dominos", 1, LocalDate.of(2015, 9, 15), "Craig Dennis", false),
            new Gif("compiler-bot", 1, LocalDate.of(2015, 2, 13), "Ada Lovelace", true),
            new Gif("cowboy-coder", 3, LocalDate.of(2015, 2, 13), "Grace Hopper", false),
            new Gif("infinite-andrew", 2, LocalDate.of(2015, 8, 23), "Marissa Mayer", true));

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public Gif findByName(String name) {
        return ALL_GIFS.stream().filter(gif ->
                gif.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Gif> findByCategoryId(int id) {
        return ALL_GIFS.stream().filter(gif ->
        gif.getCategoryId() == id).collect(Collectors.toList());
    }
}
