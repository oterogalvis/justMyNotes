package com.teamtreehouse.jobs;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class RockPaperScissor {
    private static final String winMessage = "You win the game!";
    private static final String loseMessage = "Computer win the game!";
    private static final String tieMessage = "The game is tie!";
    private static final String scissor = "scissor";
    private static final String rock = "rock";
    private static final String paper = "paper";

    public static String determineWinnerOld(String userChoice, String computerChoice) {
        String message = "";

        if (userChoice.equals(computerChoice)) {
            message = "The game is tie!";
        } else {
            if (userChoice.equals(rock)) {
                if (computerChoice.equals(scissor)) {
                    message = winMessage;
                } else {
                    message = loseMessage;
                }
            }

            if (userChoice.equals(scissor)) {
                if (computerChoice.equals(paper)) {
                    message = winMessage;
                } else {
                    message = loseMessage;
                }
            }

            if (userChoice.equals(paper)) {
                if (computerChoice.equals(rock)) {
                    message = winMessage;
                } else {
                    message = loseMessage;
                }
            }
        }
        return message;
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        String message = "";
        switch (userChoice) {
            case rock :
                message = analizeChoice(computerChoice, scissor, winMessage, loseMessage);
                break;
            case scissor :
                message = analizeChoice(computerChoice, paper, winMessage, loseMessage);
                break;
            case paper :
                message = analizeChoice(computerChoice, rock, winMessage, loseMessage);
                break;
        }
        return analizeChoice(userChoice, computerChoice, tieMessage, message);
    }

    private static String analizeChoice(String choiceA, String choiceB, String ifStatement, String elseStatement) {
        String message = "";
        if (choiceA.equals(choiceB)) {
            message = ifStatement;
        } else {
            message = elseStatement;
        }
        return message;
    }

    public static String determineWinnerLambdas(String userChoice, String computerChoice) {
//        String rockVs = universalIfLambdas(computerChoice, winMessage, loseMessage, scissor);
//        String paperVs = universalIfLambdas(computerChoice, winMessage, loseMessage, rock);
//        String scissorVs = universalIfLambdas(computerChoice, winMessage, loseMessage, paper);
//        String varius = universalIfLambdas(userChoice, rockVs, universalIfLambdas(userChoice, paperVs, paper,
//                universalIfLambdas(userChoice, scissorVs, scissor, "this is an error")), rock);
//        return universalIfLambdas(userChoice, "The game is tie!", varius, computerChoice);
        return universalIfLambdas(userChoice, "The game is tie!",
                universalIfLambdas(userChoice, universalIfLambdas(computerChoice, winMessage, loseMessage, scissor),
                        universalIfLambdas(userChoice, universalIfLambdas(computerChoice, winMessage, loseMessage, rock), paper,
                                universalIfLambdas(userChoice, universalIfLambdas(computerChoice, winMessage, loseMessage, paper),
                                        scissor, "this is an error")), rock), computerChoice);
    }

    private static String universalIfLambdas(String choiceA, String ifStatement, String elseStatement, String choiceB) {
//        return Stream.of(ifStatement).filter(message -> choiceA.equals(choiceB)).findFirst().orElse(elseStatement);
        return Optional.of(ifStatement).filter(message -> choiceA.equals(choiceB)).orElse(elseStatement);
    }

    public static void main(String[] args) {
//        System.out.println(determineWinnerLambdas("rock", "paper"));
//        System.out.println(determineWinner("rock", "paper"));
    }

    private String test(LocalDateTime date) {
        Function<LocalDateTime, String> keyEventDispatcher = age -> age.format(DateTimeFormatter.ofPattern("M / d / YY"));
        Function<String, Integer> keyEventDispatcher1 = a -> a.length();
        Function<LocalDateTime, Integer> localDateTimeVFunction = keyEventDispatcher.andThen(keyEventDispatcher1);

        "sdasd".length();
        String format = date.format(DateTimeFormatter.ofPattern("M / d / YY"));
        return format;
    }
}
