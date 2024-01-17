package org.kata.yatzy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class DiceRoll {

    List<Integer> dice;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = asList(d1, d2, d3, d4, d5);
    }

    private Collector<Integer, ?, Integer> countingSameDiceFaceOccurences = reducing(0, e -> 1, Integer::sum);

    public Map<Integer, Integer> countDiceFaces() {
        // same as using identity() as :
        // dice.stream().collect(
        //                Collectors.groupingBy(identity(), countingSameDiceFaceOccurences));
        return dice.stream().collect(
                Collectors.groupingBy(diceFace -> diceFace, countingSameDiceFaceOccurences));
    }

    public boolean isYatzy () {
        return countDiceFaces().containsValue(5);
    }

    public int getSum() {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer countOccurrence(int diceFace) {
        return countDiceFaces().getOrDefault(diceFace, 0);
    }

    private Stream<Integer> filterNumberOfDiceGreaterThan(int occurrenceNumber) {
        return countDiceFaces().entrySet().stream()
                .filter(entry -> entry.getValue() >= occurrenceNumber)
                .map(Map.Entry::getKey);
    }

    public List<Integer> findAndReverseOrderedPairs() {
        return filterNumberOfDiceGreaterThan(2)
                .sorted(reverseOrder())
                .collect(toList());
    }


}
