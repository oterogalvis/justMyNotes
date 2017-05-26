package com.treehouse.giflib.controller;

import com.treehouse.giflib.Model.Category;
import com.treehouse.giflib.Model.Gif;
import com.treehouse.giflib.data.CategoryRepository;
import com.treehouse.giflib.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jorgeotero on 5/25/17.
 */

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String getCategories(ModelMap modelMap) {
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);
        List<Gif> gifsById = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifsById);
        return "category";
    }
}
