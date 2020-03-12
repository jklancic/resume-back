package xyz.blackmonster.resume.service.util.sort;

import xyz.blackmonster.resume.service.model.JobBean;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JobSort implements Comparator<JobBean> {

    @Override
    public int compare(JobBean job1, JobBean job2) {
        return job2.getStart().compareTo(job1.getStart());
    }

    public static List<JobBean> sort(List<JobBean> list) {
        List<JobBean> sortedList = list.stream().sorted(new JobSort()).collect(Collectors.toList());

        return sortedList;
    }
}
