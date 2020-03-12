package xyz.blackmonster.resume.service.util.sort;

import xyz.blackmonster.resume.service.model.EducationBean;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EducationSort implements Comparator<EducationBean> {

    @Override
    public int compare(EducationBean education1, EducationBean education2) {
        return education2.getStart().compareTo(education1.getStart());
    }

    public static List<EducationBean> sort(List<EducationBean> list) {
        List<EducationBean> sortedList = list.stream().sorted(new EducationSort()).collect(Collectors.toList());

        return sortedList;
    }
}
