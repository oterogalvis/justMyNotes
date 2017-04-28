package com.teamtreehouse.courses.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jorgeotero on 4/25/17.
 */
public class SimpleCourseIdeaDao implements CourseIdeaDao {
    private List<CourseIdea> ideas;

    public SimpleCourseIdeaDao() {
        this.ideas = new ArrayList<>();
    }

    @Override
    public CourseIdea findBySlug(String slug) {
        return ideas.stream().filter(courseIdea ->
                courseIdea.getSlug().equals(slug)).findFirst().orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean add(CourseIdea courseIdea) {
        return ideas.add(courseIdea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
    }
}
