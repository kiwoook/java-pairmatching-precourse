package pairmatching.model;

import static pairmatching.utils.Constants.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Pairs {

    private final List<Pair> items;

    public Pairs(List<Pair> items) {
        this.items = items;
    }

    public static Pairs create(List<String> shuffleCrews) {
        if (shuffleCrews.size() % 2 == 1) {
            return new Pairs(oddPair(shuffleCrews));
        }

        return new Pairs(evenPair(shuffleCrews));
    }

    public static List<Pair> evenPair(List<String> shuffleCrews) {
        int maxTry = shuffleCrews.size() / 2;
        List<Pair> pairs = new ArrayList<>();

        for (int tryCount = 0; tryCount < maxTry; tryCount++) {
            String crew1 = shuffleCrews.get(tryCount * 2);
            String crew2 = shuffleCrews.get(tryCount * 2 + 1);

            Pair pair = Pair.create(crew1, crew2);
            pairs.add(pair);
        }

        return pairs;
    }

    public static List<Pair> oddPair(List<String> shuffleCrews) {
        int maxTry = shuffleCrews.size() / 2;
        List<Pair> pairs = new ArrayList<>();

        for (int tryCount = 0; tryCount < maxTry - 1; tryCount++) {
            String crew1 = shuffleCrews.get(tryCount * 2);
            String crew2 = shuffleCrews.get(tryCount * 2 + 1);

            Pair pair = Pair.create(crew1, crew2);
            pairs.add(pair);
        }

        pairs.add(threePair(shuffleCrews));
        return pairs;
    }

    public static Pair threePair(List<String> shuffleCrews) {
        int maxSize = shuffleCrews.size();

        String crew1 = shuffleCrews.get(maxSize - 3);
        String crew2 = shuffleCrews.get(maxSize - 2);
        String crew3 = shuffleCrews.get(maxSize - 1);

        return Pair.create(crew1, crew2, crew3);
    }

    public boolean checkDuplicatedPairsList(List<Pairs> comparePairsList) {
        for (Pairs comparePairs : comparePairsList) {
            if (checkDuplicatedPairs(comparePairs)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicatedPairs(Pairs comparePairs) {
        for (Pair pair : this.items) {
            if (comparePairs.isExistPair(pair)) {
                return true;
            }
        }

        return false;
    }

    public boolean isExistPair(Pair pair) {
        return items.contains(pair);
    }

    public String printPairs() {
        StringJoiner joiner = new StringJoiner(ENTER);
        for (Pair pair : items) {
            joiner.add(pair.printPair());
        }

        return joiner.toString();
    }



}
