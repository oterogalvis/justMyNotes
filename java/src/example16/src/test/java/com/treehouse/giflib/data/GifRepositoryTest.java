package com.treehouse.giflib.data;

import com.treehouse.giflib.Model.Gif;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jorgeotero on 5/24/17.
 */
public class GifRepositoryTest {
    private List<String> gifNames;
    private GifRepository gifRepository;

    @Before
    public void setUp() throws Exception {
        gifNames = Arrays.asList("android-explosion", "ben-and-mike", "book-dominos", "compiler-bot", "cowboy-coder", "infinite-andrew");
        gifRepository = new GifRepository();
    }


    @Test
    public void findByName() throws Exception {
        gifNames.forEach(gifName ->
                Assert.assertTrue("Assert that the return is an Gif object",
                        gifRepository.findByName(gifName) instanceof Gif));
    }

    @Test
    public void findByNameNull() throws Exception {
        Assert.assertNull(gifRepository.findByName("non-existent-gif"));
    }

    @Test
    public void findByCategoryId() throws Exception {
//        TODO: findByCategoryId() test
    }
}