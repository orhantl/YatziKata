package org.kata.yatzy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Yatzy {

    public static int chance(Roll roll) {
        return roll.getDice().stream()
                .mapToInt(Integer::intValue).sum();
    }

    public static int ones(Roll roll) {
        return sumSearchedOccurrence(roll, 1);
    }

    public static int twos(Roll roll) {
        return sumSearchedOccurrence(roll, 2);
    }

    public static int threes(Roll roll) {
        return sumSearchedOccurrence(roll, 3);
    }

    public static int fours(Roll roll) {
        return sumSearchedOccurrence(roll, 4);
    }

    public static int fives(Roll roll) {
        return sumSearchedOccurrence(roll, 5);
    }

    public static int sixes(Roll roll) {
        return sumSearchedOccurrence(roll, 6);
    }

    private static int sumSearchedOccurrence(Roll roll, int searchedOccurrence) {
        return roll.getDice().stream()
                .filter(d -> d == searchedOccurrence)
                .mapToInt(Integer::intValue).sum();
    }

    public static int smallStraight(Roll roll) {
        return isSmallStraight(roll) ? 15 : 0;
    }

    public static boolean isSmallStraight(Roll roll) {
        return new HashSet<>(roll.getDice()).containsAll(List.of(1, 2, 3, 4, 5));
    }

    public static int largeStraight(Roll roll) {
        return isLargeStraight(roll) ? 20 : 0;
    }

    private static boolean isLargeStraight(Roll roll) {
        return new HashSet<>(roll.getDice()).containsAll(List.of(2, 3, 4, 5, 6));
    }

    public static int threeOfAKind(Roll roll) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences(roll);
        Integer dieFace = getDieFaceForSearchedOccurrence(occurrences, 3);
        return dieFace * 3;
    }

    public static int fourOfAKind(Roll roll) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences(roll);
        Integer dieFace = getDieFaceForSearchedOccurrence(occurrences, 4);
        return dieFace * 4;
    }

    public static int yatzy(Roll roll) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences(roll);
        Integer yatzy = getDieFaceForSearchedOccurrence(occurrences, 5);
        return yatzy != 0 ? 50 : 0;
    }

    private static Map<Integer, Integer> countNumberOfOccurrences(Roll roll) {
        Map<Integer, Integer> occurrences = new HashMap<>(5);
        roll.getDice().forEach(d -> {
            if (occurrences.containsKey(d)) {
                occurrences.put(d, occurrences.get(d) + 1);
            } else {
                occurrences.put(d, 1);
            }
        });
        return occurrences;
    }

    private static Integer getDieFaceForSearchedOccurrence(Map<Integer, Integer> occurrences, int searchedOccurrence) {
        return occurrences.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .filter(e -> e.getValue() >= searchedOccurrence)
                .findFirst()
                .orElse(Map.entry(0, 0)).getKey();
    }

    public static int scorePair(Roll roll) {
        return findNPair(roll, 1);
    }

    public static int twoPair(Roll roll) {
        int fourOfAKind = fourOfAKind(roll);
        if (fourOfAKind != 0) {
            return fourOfAKind;
        }
        return findNPair(roll, 2);
    }

    private static int findNPair(Roll roll, int limit) {
        return roll.getDice().stream().filter(die -> roll.getDice().stream()
                        .filter(dieToBeCompare -> Objects.equals(dieToBeCompare, die))
                        .count() >= 2)
                .distinct()
                .limit(limit)
                .mapToInt(Integer::intValue)
                .sum() * 2;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}