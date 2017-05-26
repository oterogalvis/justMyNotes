package com.treehouse.giflib.data;

import com.treehouse.giflib.Model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jorgeotero on 5/25/17.
 */

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "People"),
            new Category(3, "Destruction")
    );

    public static List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        return ALL_CATEGORIES.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
    }
}
