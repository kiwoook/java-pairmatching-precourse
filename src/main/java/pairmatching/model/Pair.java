package pairmatching.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pair {

    private final Set<String> pairNames;

    public Pair(String name1, String... names) {
        this.pairNames = new HashSet<>();
        pairNames.add(name1);
        pairNames.addAll(Arrays.asList(names));
    }
}
