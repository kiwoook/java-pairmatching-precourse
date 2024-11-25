package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.enums.Course;

public class Crews {
    private final List<Crew> items;

    public Crews() {
        this.items = new ArrayList<>();
    }

    public static Crews create() {
        return new Crews();
    }

    public void addCrews(List<Crew> crews) {
        this.items.addAll(crews);
    }

    public List<Crew> getCourseCrews(Course course) {
        return items.stream()
                .filter(crew -> crew.sameCourse(course))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Crews{" +
                "crews=" + items +
                '}';
    }
}
