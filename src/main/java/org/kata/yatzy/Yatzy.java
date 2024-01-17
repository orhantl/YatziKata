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
        return dice.countOccurrence(1);
    }

    public static int twos(DiceRoll dice) {
        return dice.countOccurrence(2) * 2;
    }

    public static int threes(DiceRoll dice) {
        return dice.countOccurrence(3) * 3;
    }

    public static int fours(DiceRoll dice) {
        return dice.countOccurrence(4) * 4;
    }

    public static int fives(DiceRoll dice) {
        return dice.countOccurrence(5) * 5;
    }

    public static int sixes(DiceRoll dice) {
        return dice.countOccurrence(6) * 6;
    }


    private static int calculateScore(int diceFaceOfPair, int operand) {
        return diceFaceOfPair * operand;
    }

    public static int onePair(DiceRoll dice) {
        List<Integer> potentialPairs = dice.findAndReverseOrderCombination(2);

        if (potentialPairs.isEmpty()) {
            return 0;
        } else {
            return calculateScore(potentialPairs.get(0),2);
        }
    }

    public static int twoPairs(DiceRoll dice) {
        List<Integer> potentialPairs = dice.findAndReverseOrderCombination(2);
        if (potentialPairs.size() < 2) {
            return 0;
        } else {
            return calculateScore(potentialPairs.get(0),2)
                    + calculateScore(potentialPairs.get(1), 2);
        }
    }

    public static int threeOfAKind(DiceRoll dice) {
        List<Integer> potentialThreeOfAKind = dice.findAndReverseOrderCombination(3);
        if (potentialThreeOfAKind.isEmpty()) {
            return 0;
        } else {
            return calculateScore(potentialThreeOfAKind.get(0) ,3);
        }
    }

    public static int fourOfAKind(DiceRoll dice) {
        List<Integer> potentialFourOfAKind = dice.findAndReverseOrderCombination(4);
        if (potentialFourOfAKind.isEmpty()) {
            return 0;
        } else {
            return calculateScore(potentialFourOfAKind.get(0),4);
        }
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