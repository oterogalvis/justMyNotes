package com.teamtreehouse.courses;

import com.teamtreehouse.courses.model.*;
import spark.HaltException;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by jorgeotero on 4/24/17.
 */
public class Main {

    public static void main(String[] args) {
        staticFileLocation("/public");

        CourseIdeaDao dao = new SimpleCourseIdeaDao();

        before((request, response) -> {
            if (null == request.attribute("model")) {
                Map<String, Object> model = new HashMap<>();
                request.attribute("model", model);
            }
            if (null != request.cookie("username")) {
                HashMap model = request.attribute("model");
                model.put("username", request.cookie("username"));
            }
        });

        before("/ideas", (request, response) -> {
            HashMap model = request.attribute("model");
            if (null == model.get("username")) {
                FlashMessage.setFlashMessage(request, "Please sign in first!");
                response.redirect("/");
                halt();
            }
        });

        get("/", (request, response) -> {
//            Map<String, String> model = new HashMap<>();
            HashMap model = request.attribute("model");
//            model.put("username", request.attribute("username"));
            model.put("flashMessage", FlashMessage.captureFlashMessage(request));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (request, response) -> {
//            Map<String, String> model = new HashMap<>();
            HashMap model = request.attribute("model");
            String username = request.queryParams("username");
            response.cookie("username", username);
            response.redirect("/");
            return null;
        });

        get("/ideas", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
            HashMap model = request.attribute("model");
            model.put("ideas", dao.findAll());
            model.put("flashMessage", FlashMessage.captureFlashMessage(request));
            return new ModelAndView(model, "ideas.hbs");
        }, new HandlebarsTemplateEngine());

        post("/ideas", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
            HashMap model = request.attribute("model");
            String title = request.queryParams("title");
            CourseIdea courseIdea = new CourseIdea(title, (String) model.get("username"));
            dao.add(courseIdea);
            response.redirect("/ideas");
            return null;
        });

        post("/ideas/:slug/vote", (request, response) -> {
            HashMap model = request.attribute("model");
            CourseIdea courseIdea = dao.findBySlug(request.params("slug"));
            boolean added = courseIdea.addVoter((String) model.get("username"));
            if (added) {
                FlashMessage.setFlashMessage(request, "Thanks for your vote!");
            } else {
                FlashMessage.setFlashMessage(request, "You already voted!");
            }
            response.redirect("/ideas");
            return null;
        });

        get("/ideas/:slug", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
            HashMap model = request.attribute("model");
            model.put("idea", dao.findBySlug(request.params("slug")));
            return new ModelAndView(model, "idea.hbs");
        }, new HandlebarsTemplateEngine());

        exception(NotFoundException.class, (exception, request, response) -> {
            response.status(404);
            HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
            String html = engine.render(new ModelAndView(null, "not-found.hbs"));
            response.body(html);
        });
    }
}
