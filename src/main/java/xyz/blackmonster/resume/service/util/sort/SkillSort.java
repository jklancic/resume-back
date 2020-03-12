package xyz.blackmonster.resume.service.util.sort;

import xyz.blackmonster.resume.service.model.SkillBean;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SkillSort implements Comparator<SkillBean> {

    @Override
    public int compare(SkillBean skill1, SkillBean skill2) {
        float skillValue1 = (skill1.getRating().floatValue() / skill1.getScale().floatValue()) * 10;
        float skillValue2 = (skill2.getRating().floatValue() / skill2.getScale().floatValue()) * 10;

        return Math.round(skillValue2 - skillValue1);
    }

    public static List<SkillBean> sort(List<SkillBean> list) {
        List<SkillBean> sortedList = list.stream().sorted(new SkillSort()).collect(Collectors.toList());

        return sortedList;
    }
}
