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
        return new Pairs(generatePairs(shuffleCrews));
    }

    public static List<Pair> generatePairs(List<String> shuffleCrews) {
        int size = shuffleCrews.size();
        List<Pair> pairs = new ArrayList<>();

        // GPT 보고 고쳐달라했으여...
        for (int i = 0; i < size - 1; i += 2) {
            if (i + 3 == size) {
                pairs.add(Pair.create(shuffleCrews.get(i), shuffleCrews.get(i + 1), shuffleCrews.get(i + 2)));
                continue;
            }

            if (i + 1 < size) {
                pairs.add(Pair.create(shuffleCrews.get(i), shuffleCrews.get(i + 1)));
            }
        }

        return pairs;
    }

    public boolean checkDuplicatedPairsList(List<Pairs> comparePairsList) {
        for (Pairs comparePairs : comparePairsList) {
            if (checkDuplicatedPairs(comparePairs)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicatedPairs(Pairs comparePairs) {
        for (Pair pair : this.items) {
            if (comparePairs.isExistPair(pair)) {
                return true;
            }
        }

        return false;
    }

    // 해당 메서드가 정상적으로 돌아갈려면 Pair의 동등성이 보장되어야 한다.
    // pair 의 equals hashcode를 재정의하여야 함.
    private boolean isExistPair(Pair pair) {
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
