package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.enums.Course;

public class Crews {


    private final List<Crew> crews;

    public Crews() {
        this.crews = new ArrayList<>();
    }

    public static Crews create() {
        return new Crews();
    }

    public void addCrews(List<Crew> crews) {
        this.crews.addAll(crews);
    }

    public void addCrew(String name, Course course) {
        crews.add(Crew.of(name, course));
    }

    public List<Crew> getCourseCrews(Course course) {
        return crews.stream()
                .filter(crew -> crew.sameCourse(course))
                .collect(Collectors.toList());
    }




}
