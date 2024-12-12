package pairmatching.model;

import static pairmatching.utils.Constants.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import pairmatching.exception.CustomIllegalArgumentException;

public class Pairs {

    private final List<Pair> items;

    public Pairs(List<Pair> items) {
        this.items = items;
    }

    public static Pairs create(List<String> names) {
        if (names.size() % 2 == 0) {
            return new Pairs(odd(names));
        }

        return new Pairs(even(names));
    }

    public static void valid(List<String> names) {
        if (names.size() < 2) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_MATCHING);
        }
    }


    public static List<Pair> odd(List<String> names) {
        List<Pair> items = new ArrayList<>();
        for (int i = 0; i < names.size() / 2; i++) {
            items.add(new Pair(names.get(i), names.get(i + 1)));
        }

        return items;
    }

    public static List<Pair> even(List<String> names) {
        List<Pair> items = new ArrayList<>();
        for (int i = 0; i < names.size() / 2 - 1; i++) {
            items.add(new Pair(names.get(i), names.get(i + 1)));
        }

        int lastIdx = names.size() - 3;
        items.add(new Pair(names.get(lastIdx), names.get(lastIdx + 1), names.get(lastIdx + 2)));

        return items;
    }


    public boolean hasPair(Pair pair) {
        return items.contains(pair);
    }

    public boolean hasSamePair(List<Pairs> pairsList) {
        for (Pairs pairs : pairsList) {
            if (hasSamePair(pairs)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSamePair(Pairs pairs) {
        for (Pair comaprePair : pairs.items) {
            if (this.hasPair(comaprePair)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(ENTER);

        for (Pair item : items) {
            joiner.add(item.toString());
        }

        return joiner.toString();
    }
}
