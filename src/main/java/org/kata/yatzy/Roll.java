package org.kata.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Roll {
    public static final List<Integer> SMALL_STRAIGHT = List.of(1, 2, 3, 4, 5);
    public static final List<Integer> LARGE_STRAIGHT = List.of(2, 3, 4, 5, 6);
    private List<Integer> dice;

    private Roll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
        dice.sort(Comparator.reverseOrder());
    }

    public static Roll of(int d1, int d2, int d3, int d4, int d5) {
        return new Roll(d1, d2, d3, d4, d5);
    }


    public int sumDiceValues() {
        return dice.stream()
                .mapToInt(Integer::intValue).sum();
    }

    public int sumSearchedOccurrence(int searchedOccurrence) {
        return dice.stream()
                .filter(d -> d == searchedOccurrence)
                .mapToInt(Integer::intValue).sum();
    }

    public boolean isSmallStraight() {
        return new HashSet<>(dice).containsAll(SMALL_STRAIGHT);
    }
    
    public boolean isLargeStraight() {
        return new HashSet<>(dice).containsAll(LARGE_STRAIGHT);
    }

    private Map<Integer, Integer> countNumberOfOccurrences() {
        Map<Integer, Integer> occurrences = new HashMap<>(5);
        dice.forEach(d -> {
            if (occurrences.containsKey(d)) {
                occurrences.put(d, occurrences.get(d) + 1);
            } else {
                occurrences.put(d, 1);
            }
        });
        return occurrences;
    }

    public Integer getDieFaceForSearchedOccurrence(int searchedOccurrence) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences();
        return occurrences.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .filter(e -> e.getValue() >= searchedOccurrence)
                .findFirst()
                .orElse(Map.entry(0, 0)).getKey();
    }

    public int findNPair(int limit) {
        return dice.stream().filter(die -> dice.stream()
                        .filter(dieToBeCompare -> Objects.equals(dieToBeCompare, die))
                        .count() >= 2)
                .distinct()
                .limit(limit)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean isYatzy() {
        Integer potentialYatzy = getDieFaceForSearchedOccurrence(5);
        if (potentialYatzy != 0) {
            return true;
        }
        return false;
    }

    public boolean isFullHouse() {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences();
        return occurrences.containsValue(3) && occurrences.containsValue(2);
    }
}
