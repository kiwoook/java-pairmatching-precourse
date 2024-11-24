package pairmatching.model;

import pairmatching.enums.Course;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    // TODO 이름에 대한 검증 로직 생성

    public static Crew of(String name, Course course) {
        return new Crew(name, course);
    }

    public boolean sameCourse(Course course) {
        return this.course == course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
