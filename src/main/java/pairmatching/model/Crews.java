package pairmatching.model;

import java.util.List;

public class Crews {

    private List<Crew> backends;
    private List<Crew> frontends;

    public Crews(List<Crew> backends, List<Crew> frontends) {
        this.backends = backends;
        this.frontends = frontends;
    }

    public static Crews of(List<Crew> backends, List<Crew> frontends) {
        return new Crews(backends, frontends);
    }

    @Override
    public String toString() {
        return "Crews{" +
                "backends=" + backends +
                ", frontends=" + frontends +
                '}';
    }
}
