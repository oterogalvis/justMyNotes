package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTwo {

    public static void main(String[] args) {
        JobService service = new JobService();
        boolean shouldRefresh = false;
        try {
            if (shouldRefresh) {
                service.refresh();
            }
            List<Job> jobs = service.loadJobs();
            System.out.printf("Total jobs:  %d %n %n", jobs.size());
            explore(jobs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------------- IMPERATIVELY ----------------
    public static Map<String, Long> getSnippetWordCountsImperatively(List<Job> jobs) {

        Map<String, Long> wordCounts = new HashMap<>();

        for (Job job : jobs) {
            String[] words = job.getSnippet().split("\\W+");
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                String lWord = word.toLowerCase();
                Long count = wordCounts.get(lWord);
                if (count == null) {
                    count = 0L;
                }
                wordCounts.put(lWord, ++count);
            }
        }
        return wordCounts;
    }

    // ---------------- DECLARATIVELY ----------------
    public static Map<String, Long> getSnippetWordCountsStream(List<Job> jobs) {

    /*Collectors.groupingBy() allow you to set a value and the other
        one will be the the List<T> the collector is getting.*/
        Map<String, List<String>> groupingByExample = jobs.stream().map(Job::getSnippet)
                .map(snippet -> snippet.split("\\W+")).flatMap(Stream::of)
                .filter(word -> word.length() > 0).map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word));

        Map<String, Integer> toMapExample = jobs.stream().map(Job::getSnippet)
                .map(snippet -> snippet.split("\\W+")).flatMap(Stream::of)
                .filter(word -> word.length() > 0).map(String::toLowerCase)
                .collect(Collectors.toMap(word -> word, word -> word.length()));

        Map<String, Long> anotherVersion = jobs.stream().map(job -> job.getSnippet().split("\\W+"))
                .flatMap(Stream::of).filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(word -> word.toLowerCase(), Collectors.counting()));

        return jobs.stream().map(Job::getSnippet)
                .map(snippet -> snippet.split("\\W+")).flatMap(Stream::of)
                .filter(word -> word.length() > 0).map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


        private static void explore(List<Job> jobs) {

        }
}
