package pairmatching.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Pair {

    private final Set<Crew> pairCrews;

    public Pair(Set<Crew> pairCrews) {
        this.pairCrews = pairCrews;
    }

    // 아니 set.of 안되는거 실화냐...
    public static Pair create(Crew crew1, Crew crew2) {
        return new Pair(new LinkedHashSet<>(Arrays.asList(crew1, crew2)));
    }

    public static Pair create(Crew crew1, Crew crew2, Crew crew3) {
        return new Pair(new LinkedHashSet<>(Arrays.asList(crew1, crew2, crew3)));
    }

    // 페어끼리 비교하는 메서드
    public boolean isDuplicatedPair(Pair comparePair) {
        return pairCrews.equals(comparePair.pairCrews);
    }

    public String printPair() {
        StringJoiner joiner = new StringJoiner(" : ");

        for (Crew crew : pairCrews) {
            joiner.add(crew.getName());
        }

        return joiner.toString();
    }




}
