package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import pairmatching.exception.CustomIllegalArgumentException;

public class Matching {

    private final Map<CourseMission, Pairs> match;

    public Matching() {
        this.match = new HashMap<>();
    }

    public static Matching create() {
        return new Matching();
    }

    public boolean hasCourseMission(CourseMission courseMission) {
        return match.containsKey(courseMission);
    }

    public void process(int tryCount, CourseMission courseMission, Crews crews) {
        if (tryCount >= 3) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_MATCHING);
        }

        Course course = courseMission.getCourse();

        List<String> crewNames = getShuffleNamesByCourse(course, crews);
        Pairs pairs = Pairs.create(crewNames);

        Level level = courseMission.getMission().getLevel();
        List<Pairs> parisBySameLevel = getParisBySameLevel(level);

        if (pairs.hasSamePair(parisBySameLevel)) {
            process(tryCount + 1, courseMission, crews);
            return;
        }
        match.put(courseMission, pairs);
    }


    private List<String> getShuffleNamesByCourse(Course course, Crews crews) {
        if (course == Course.BACKEND) {
            return crews.getShuffleBackendNames();
        }

        return crews.getShuffleFrontendNames();
    }

    private List<Pairs> getParisBySameLevel(Level level) {
        List<Pairs> pairs = new ArrayList<>();
        for (Entry<CourseMission, Pairs> entry : match.entrySet()) {
            CourseMission courseMission = entry.getKey();
            Pairs value = entry.getValue();
            if (courseMission.getMission().getLevel().equals(level)) {
                pairs.add(value);
            }
        }

        return pairs;
    }

    public String toResult(CourseMission courseMission) {
        if (!match.containsKey(courseMission)) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_MATCHING);
        }
        return match.get(courseMission).toString();
    }

    public void clear() {
        match.clear();
    }
}
