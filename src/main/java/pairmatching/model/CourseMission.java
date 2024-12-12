package pairmatching.model;

import pairmatching.utils.StringUtils;

public class CourseMission {

    private Course course;
    private Mission mission;

    public CourseMission(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static CourseMission of(String input) {
        String[] split = StringUtils.split(", ", input, 3);
        Course course = Course.from(split[0]);
        Level level = Level.from(split[1]);
        Mission mission = Mission.of(split[2], level);

        return new CourseMission(course, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
