package com.teamtreehouse.jobs;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class IntroductionToFunctionalProgramming {

    public static void yell(String sentece) {
        Objects.requireNonNull(sentece, () -> "Created issue " + IntroductionToFunctionalProgramming.createIssue());
        System.out.printf("%s!! \n", sentece);
    }

    private static String createIssue() {
        System.out.println("Creating jira ticket");
        return "DC-XXXX";
    }

    public static void main(String[] args) {
        List<String> ingredients = Arrays.asList(
                "flour",
                "milk",
                "baking powder",
                "butter",
                "eggs",
                "milk"
        );


        for (String ingredient : ingredients) {
            System.out.println(ingredient);
        }

        ingredients.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        ingredients.forEach(ingredient -> System.out.println(ingredient));

        Consumer<String> ingredientConsumer = ingredient -> System.out.println(ingredient);
        ingredients.forEach(ingredientConsumer);

        ingredients.forEach(System.out::println);

        ingredients.forEach(IntroductionToFunctionalProgramming::yell);

        yell(null);
    }
}
