package com.treehouse.giflib.data;

import com.treehouse.giflib.Model.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jorgeotero on 5/25/17.
 */
public class CategoryRepositoryTest {
    private CategoryRepository categoryRepository;
    private List<Integer> idList;

    @Before
    public void setUp() throws Exception {
        idList = Arrays.asList(1, 2, 3);
        categoryRepository = new CategoryRepository();
    }

    @Test
    public void findById() throws Exception {
        idList.forEach(id ->
                Assert.assertTrue("Assert that the return is an Category object",
                        categoryRepository.findById(id) instanceof Category));
    }

    @Test
    public void findByIdNull() throws Exception {
        Assert.assertNull(categoryRepository.findById(4));
    }
}