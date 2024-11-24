package pairmatching.enums;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course parseCourse(String input) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 코스명입니다."));

    }

    public String getName() {
        return name;
    }
}