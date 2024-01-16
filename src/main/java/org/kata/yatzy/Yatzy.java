package org.kata.yatzy;

import java.util.List;

import static java.util.Arrays.asList;

public class Yatzy {

    public static int chance(DiceRoll dice) {
        return dice.getSum();
    }

    public static int yatzy(DiceRoll dice) {
       if (dice.isYatzy()) {
           return 50;
       } else {
           return 0;
       }
    }

    public static int ones(DiceRoll dice) {
        return dice.sumTheOccurrencesOfTheGivenDiceFace(1);
    }

    public static int twos(DiceRoll dice) {
        return dice.sumTheOccurrencesOfTheGivenDiceFace(2);
    }

    public static int threes(DiceRoll dice) {
        return dice.sumTheOccurrencesOfTheGivenDiceFace(3);
    }

    public static int fours(DiceRoll dice) {
        return dice.sumTheOccurrencesOfTheGivenDiceFace(4);
    }

    public static int fives(DiceRoll dice) {
        return dice.sumTheOccurrencesOfTheGivenDiceFace(5);
    }

    public static int sixes(DiceRoll dice) {
        return dice.sumTheOccurrencesOfTheGivenDiceFace(6);
    }

    public static int onePair(DiceRoll dice) {
        List<Integer> potentialPairs = dice.findAndReverseOrderedPairs();

        if (potentialPairs.isEmpty()) {
            return 0;
        } else {
            return potentialPairs.get(0) * 2;
        }
    }

    public static int twoPairs(DiceRoll dice) {
        List<Integer> potentialPairs = dice.findAndReverseOrderedPairs();
        if (potentialPairs.size() < 2) {
            return 0;
        } else {
            return potentialPairs.get(0) * 2 + potentialPairs.get(1) * 2;
        }
    }

    public static int threeOfAKind(DiceRoll dice) {
        return dice.countDiceFaces().entrySet().stream()
                .filter(entry -> entry.getValue() >= 3)
                .map(entry -> entry.getKey() * 3)
                .findFirst()
                .orElse(0);
    }

    public static int fourOfAKind(DiceRoll dice) {
        return dice.countDiceFaces().entrySet().stream()
                .filter(entry -> entry.getValue() >= 4)
                .map(entry -> entry.getKey() * 4)
                .findFirst()
                .orElse(0);
    }

    public static int smallStraight(DiceRoll dice) {
        return dice.dice.stream()
                .sorted()
                .distinct()
                .toList().equals(asList(1, 2, 3, 4, 5)) ? 15 : 0;
    }

    public static int largeStraight(DiceRoll dice) {
        return dice.dice.stream()
                .sorted()
                .distinct()
                .toList().equals(asList(2, 3, 4, 5, 6)) ? 20 : 0;
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