package pairmatching.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Pair {

    private final Set<String> pairNames;

    public Pair(String name1, String... names) {
        this.pairNames = new LinkedHashSet<>();
        pairNames.add(name1);
        pairNames.addAll(Arrays.asList(names));
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" : ");

        for (String name : pairNames) {
            joiner.add(name);
        }

        return joiner.toString();
    }
}
