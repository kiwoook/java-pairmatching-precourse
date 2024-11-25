package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.exception.InvalidShuffleException;

public class MissionPairs {

    private static final int MIN_PERSON = 2;
    private static final int MAX_RETRY = 3;

    private final Map<CourseMission, Pairs> courseMissionPairs;

    public MissionPairs() {
        this.courseMissionPairs = new HashMap<>();
    }

    public static MissionPairs create() {
        return new MissionPairs();
    }

    public boolean existCourseMission(CourseMission courseMission) {
        return courseMissionPairs.containsKey(courseMission);
    }

    public void shufflePair(int retry, Crews crews, CourseMission courseMission) {
        if (retry == MAX_RETRY) {
            throw new IllegalArgumentException("매칭이 불가능합니다!");
        }
        Course course = courseMission.getCourse();
        Level level = courseMission.getMission().getLevel();

        List<String> courseCrews = getCrewsByCourse(crews, course);
        validMinimumPerson(courseCrews);

        Pairs pairs = Pairs.create(Randoms.shuffle(courseCrews));
        if (pairs.checkDuplicatedPairsList(getPairsByCourseAndLevel(course, level))) {
            shufflePair(retry + 1, crews, courseMission);
        }

        courseMissionPairs.put(courseMission, pairs);
    }


    public void reset() {
        courseMissionPairs.clear();
    }

    private List<String> getCrewsByCourse(Crews crews, Course course) {
        return crews.getCourseCrews(course)
                .stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    private void validMinimumPerson(List<String> courseCrews) {
        if (courseCrews.size() < MIN_PERSON) {
            throw new InvalidShuffleException("처리할 수 없는 매칭입니다.");
        }
    }

    private List<Pairs> getPairsByCourseAndLevel(Course course, Level level) {
        return courseMissionPairs.entrySet()
                .stream()
                .filter(entrySet -> isSameCourseAndLevel(entrySet, course, level))
                .map(Entry::getValue)
                .collect(Collectors.toList());
    }

    private boolean isSameCourseAndLevel(Entry<CourseMission, Pairs> entry, Course course, Level level) {
        Course courseKey = entry.getKey().getCourse();
        Level levelKey = entry.getKey().getMission().getLevel();

        return courseKey.equals(course) && levelKey.equals(level);
    }

    public String toMessage(CourseMission courseMission) {
        Pairs pairs = courseMissionPairs.get(courseMission);

        if (pairs == null) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }

        return pairs.printPairs();
    }

    @Override
    public String toString() {
        return "MissionPairs{" +
                "courseMissionPairs=" + courseMissionPairs +
                '}';
    }
}
