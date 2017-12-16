package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppThree {

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

    public static String luckySearchJobImperatively(List<Job> jobs) {
        String message = null;
        String searchTerm = "java";
        for (Job job : jobs) {
            if (job.getTitle().toLowerCase().contains(searchTerm)) {
                message = job.getTitle();
                break;
            } else {
                message = "No jobs found";
            }
        }
        return message;
    }

    public static String luckySearchJobDeclaratively(List<Job> jobs) {
        String searchTerm = "java";
        return jobs.stream().map(Job::getTitle)
                .filter(title -> title.toLowerCase().contains(searchTerm))
//                .findFirst().isPresent(); This return a boolean.
                .findFirst().orElse("No jobs found");
    }

    private Optional<String> longestCompanyName(List<Job> jobs) {
//        IntStream.of(1,2,3,4,5) .sum() OR .min() OR .max OR .average().

        return jobs.stream().map(Job::getCompany)
//                .max((company1, company2) -> company1.length() - company2.length());
                .max(Comparator.comparing(String::length));
    }
    private void justNotes() {
        /*
        //TODO    Example of how the regular .map return a Stream<T> and .mapInt return a IntStream.
        Stream<Integer> integerStream = records.stream().map(HousingRecord::getCurrentHomeValueIndex);
        IntStream intStream = records.stream().mapToInt(HousingRecord::getCurrentHomeValueIndex);
        */
    }

    private static void listOf20Companies(List<Job> jobs) {
        List<String> companies = jobs.stream().map(Job::getCompany).distinct().sorted().collect(Collectors.toList());

        for (int i = 0 ; i < 20 ; i++) {
            System.out.printf("%d. %s\n", i + 1, companies.get(i));
        }
    }

    private static void listOf20CompaniesDeclaratively(List<Job> jobs) {
        List<String> companies = jobs.stream().map(Job::getCompany).distinct().sorted().collect(Collectors.toList());

        IntStream.rangeClosed(1, 20).mapToObj(i -> String.format("%d. %s", i, companies.get(i)))
                .forEach(System.out::println);
    }

    private static void explore(List<Job> jobs) {
        listOf20CompaniesDeclaratively(jobs);
    }
}
