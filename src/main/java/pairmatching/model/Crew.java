package pairmatching.model;

public class Crew {

    private final String name;

    public Crew(String name) {
        this.name = name;
    }

    public static Crew from(String name) {
        return new Crew(name);
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                '}';
    }
}
