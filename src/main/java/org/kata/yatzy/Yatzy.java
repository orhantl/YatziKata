package org.kata.yatzy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return Stream.of(d1, d2, d3, d4, d5)
                .mapToInt(Integer::intValue).sum();
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumSearchedOccurrence(d1, d2, d3, d4, d5, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumSearchedOccurrence(d1, d2, d3, d4, d5, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumSearchedOccurrence(d1, d2, d3, d4, d5, 3);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return sumSearchedOccurrence(d1, d2, d3, d4, d5, 4);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return sumSearchedOccurrence(d1, d2, d3, d4, d5, 5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return sumSearchedOccurrence(d1, d2, d3, d4, d5, 6);
    }

    private static int sumSearchedOccurrence(int d1, int d2, int d3, int d4, int d5, int searchedOccurrence) {
        return Stream.of(d1, d2, d3, d4, d5)
                .filter(d -> d == searchedOccurrence)
                .mapToInt(Integer::intValue).sum();
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        return isSmallStraight(d1, d2, d3, d4, d5) ? 15 : 0;
    }

    public static boolean isSmallStraight(int d1, int d2, int d3, int d4, int d5) {
        return List.of(d1, d2, d3, d4, d5).containsAll(List.of(1, 2, 3, 4, 5));
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        return isLargeStraight(d1, d2, d3, d4, d5) ? 20 : 0;
    }

    private static boolean isLargeStraight(int d1, int d2, int d3, int d4, int d5) {
        return List.of(d1, d2, d3, d4, d5).containsAll(List.of(2, 3, 4, 5, 6));
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences(List.of(d1, d2, d3, d4, d5));
        Integer dieFace = getDieFaceForSearchedOccurrence(occurrences, 3);
        return dieFace * 3;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences(List.of(d1, d2, d3, d4, d5));
        Integer dieFace = getDieFaceForSearchedOccurrence(occurrences, 4);
        return dieFace * 4;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> occurrences = countNumberOfOccurrences(List.of(d1, d2, d3, d4, d5));
        Integer yatzy = getDieFaceForSearchedOccurrence(occurrences, 5);
        return yatzy != 0 ? 50 : 0;
    }

    private static Map<Integer, Integer> countNumberOfOccurrences(List<Integer> dice) {
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

    private static Integer getDieFaceForSearchedOccurrence(Map<Integer, Integer> occurrences, int searchedOccurrence) {
        return occurrences.entrySet().stream()
                .filter(e -> e.getValue() >= searchedOccurrence)
                .findFirst()
                .orElse(Map.entry(0, 0)).getKey();
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1 - 1]++;
        counts[d2 - 1]++;
        counts[d3 - 1]++;
        counts[d4 - 1]++;
        counts[d5 - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
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