package org.kata.yatzy;

import java.util.List;

public class Yatzy {

    public static int chance(DiceRoll dices) {
        return dices.getSum();
    }

    public static int yatzy(DiceRoll dices) {
        return dices.countDiceFaces().containsValue(5) ? 50 : 0;
    }

    public static int ones(DiceRoll dices) {
        return dices.sumTheOccurrencesOfTheGivenDiceFace(1);
    }

    public static int twos(DiceRoll dices) {
        return dices.sumTheOccurrencesOfTheGivenDiceFace(2);
    }

    public static int threes(DiceRoll dices) {
        return dices.sumTheOccurrencesOfTheGivenDiceFace(3);
    }

    public static int fours(DiceRoll dices) {
        return dices.sumTheOccurrencesOfTheGivenDiceFace(4);
    }

    public static int fives(DiceRoll dices) {
        return dices.sumTheOccurrencesOfTheGivenDiceFace(5);
    }

    public static int sixes(DiceRoll dices) {
        return dices.sumTheOccurrencesOfTheGivenDiceFace(6);
    }

    public static int onePair(DiceRoll dices) {
        List<Integer> potentialPairs = dices.findAndReverseOrderedPairs();

        if (potentialPairs.isEmpty()) {
            return 0;
        } else {
            return potentialPairs.get(0) * 2;
        }
    }

    public static int twoPairs(DiceRoll dices) {
        List<Integer> potentialPairs = dices.findAndReverseOrderedPairs();
        if (potentialPairs.size() < 2) {
            return 0;
        } else {
            return potentialPairs.get(0) * 2 + potentialPairs.get(1) * 2;
        }
    }

    public static int threeOfAKind(DiceRoll dices) {
        return dices.countDiceFaces().entrySet().stream()
                .filter(entry -> entry.getValue() >= 3)
                .map(entry -> entry.getKey() * 3)
                .findFirst()
                .orElse(0);
    }

    public static int fourOfAKind(DiceRoll dices) {
        return dices.countDiceFaces().entrySet().stream()
                .filter(entry -> entry.getValue() >= 4)
                .map(entry -> entry.getKey() * 4)
                .findFirst()
                .orElse(0);
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
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