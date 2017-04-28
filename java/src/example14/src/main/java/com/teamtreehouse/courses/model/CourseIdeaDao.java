package com.teamtreehouse.courses.model;

import java.util.List;

/**
 * Created by jorgeotero on 4/25/17.
 */
public interface CourseIdeaDao {
    boolean add(CourseIdea courseIdea);

    List<CourseIdea> findAll();

    CourseIdea findBySlug(String slug);
}
