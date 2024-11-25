package pairmatching.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Pair {

    private final Set<String> pairCrews;

    public Pair(Set<String> pairCrews) {
        this.pairCrews = pairCrews;
    }

    public static Pair create(String crew1, String crew2) {
        return new Pair(new LinkedHashSet<>(Arrays.asList(crew1, crew2)));
    }

    public static Pair create(String crew1, String crew2, String crew3) {
        return new Pair(new LinkedHashSet<>(Arrays.asList(crew1, crew2, crew3)));
    }

    public String printPair() {
        StringJoiner joiner = new StringJoiner(" : ");

        for (String crew : pairCrews) {
            joiner.add(crew);
        }

        return joiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return Objects.equals(pairCrews, pair.pairCrews);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pairCrews);
    }
}
