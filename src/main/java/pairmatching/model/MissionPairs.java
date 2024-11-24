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

    // 백엔드와 프론트엔드 레벨 별 크루를 저장한다.

    private final Map<CourseMission, Pairs> courseMissionPairs;

    public MissionPairs() {
        this.courseMissionPairs = new HashMap<>();
    }

    public static MissionPairs create() {
        return new MissionPairs();
    }

    // TODO 페어가 이미 있으면 사용자에게 알려야한다.
    public boolean existMissionPairs(CourseMission courseMission) {
        return courseMissionPairs.containsKey(courseMission);
    }


    // 해당 미션에 대해 섞는 메서드
    public void shufflePair(int retry, Crews crews, CourseMission courseMission) {
        if (retry == MAX_RETRY) {
            throw new IllegalArgumentException("매칭이 불가능합니다!");
        }

        Course course = courseMission.getCourse();
        List<Crew> courseCrews = crews.getCourseCrews(course);
        validMinimumPerson(courseCrews);

        List<Crew> shuffleCrew = Randoms.shuffle(courseCrews);
        Pairs pairs = Pairs.create(shuffleCrew);
        Level level = courseMission.getMission().getLevel();

        if (pairs.checkDuplicatedPairsList(getPairsByCourseAndLevel(course, level))) {
            shufflePair(retry + 1, crews, courseMission);
        }

        // 문제가 없다면 페어로 설정한다.
        courseMissionPairs.put(courseMission, pairs);
    }

    public void reset() {
        courseMissionPairs.clear();
    }

    private void validMinimumPerson(List<Crew> courseCrews) {
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

    public String findPairs(CourseMission courseMission) {
        Pairs pairs = courseMissionPairs.get(courseMission);

        if (pairs == null) {
            throw new IllegalArgumentException("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        }

        return pairs.printPairs();
    }

}
