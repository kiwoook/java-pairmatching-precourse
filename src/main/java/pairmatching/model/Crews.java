package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private final List<Crew> backends;
    private final List<Crew> frontends;

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

    public List<String> getBackendNames() {
        return backends.stream().map(Crew::getName).collect(Collectors.toList());
    }

    public List<String> getFrontendNames() {
        return frontends.stream().map(Crew::getName).collect(Collectors.toList());
    }
}
