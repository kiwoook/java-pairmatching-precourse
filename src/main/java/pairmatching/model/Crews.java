package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
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

    public List<String> getShuffleBackendNames() {
        return Randoms.shuffle(backends.stream().map(Crew::getName).collect(Collectors.toList()));
    }

    public List<String> getShuffleFrontendNames() {
        return Randoms.shuffle(frontends.stream().map(Crew::getName).collect(Collectors.toList()));
    }
}
