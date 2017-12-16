package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

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
    private static void printPortlandJobsImperatively(List<Job> jobs) {
        for (Job job : jobs) {
            if (job.getState().equals("OR") && job.getCity().equals("Portland")) {
                System.out.println(job);
            }
        }
    }

    private static List<Job> getTreeJuniorsJobsImperatively(List<Job> jobs) {
        ArrayList<Job> juniorJobs = new ArrayList<>();
        for (Job job : jobs) {
            String title = job.getTitle().toLowerCase();
            if (title.contains("junior") || title.contains("jr")) {
                juniorJobs.add(job);
                if (juniorJobs.size() >= 3) {
                    break;
                }
            }
        }
        return juniorJobs;
    }

    private static List<String> getCaptionsImperatively(List<Job> jobs) {
        ArrayList<String> captions = new ArrayList<>();
        for (Job job : jobs) {
            if (isJuniorJob(job)) {
                String caption = String.format("%s is looking for a %s in %s",
                        job.getCompany(),
                        job.getTitle(),
                        job.getCity());
                captions.add(caption);
                if (captions.size() >= 3) {
                    break;
                }
            }
        }
        return captions;
    }

    // ---------------- DECLARATIVELY ----------------
    private static void printPortlandJobsStream(List<Job> jobs) {
        jobs.stream()
                .filter(job -> job.getState().equals("OR"))
                .filter(job -> job.getCity().equals("Portland"))
                .forEach(System.out::println);
    }

    private static List<Job> getTreeJuniorsJobsStream(List<Job> jobs) {
        return jobs.stream().filter(App::isJuniorJob).limit(3)
                .collect(Collectors.toList());
    }

    private static boolean isJuniorJob(Job job) {
        String title = job.getTitle().toLowerCase();
        return title.contains("junior") || title.contains("jr");
    }

    private static List<String> getCaptionsStream(List<Job> jobs) {
        return jobs.stream().filter(App::isJuniorJob)
                .map(Job::getCaption)
                .limit(3).collect(Collectors.toList());
    }

    private static void explore(List<Job> jobs) {
        getCaptionsStream(jobs).forEach(System.out::println);
    }
}
