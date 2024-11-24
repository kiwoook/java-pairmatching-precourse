package pairmatching.model;

import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.enums.Mission;

public class CourseMission {

    private final Course course;
    private final Mission mission;

    public CourseMission(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static CourseMission parseInput(String input) {
        String[] split = splitMissionInput(input);

        Course course = Course.parseCourse(split[0]);
        Level level = Level.from(split[1]);
        Mission mission = Mission.of(split[2], level);

        return new CourseMission(course, mission);
    }

    public static String[] splitMissionInput(String input) {
        boolean startsWith = input.startsWith(",");
        boolean endWith = input.endsWith(",");

        if (startsWith || endWith) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] split = input.split(", ");
        if (split.length != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return split;
    }


    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
