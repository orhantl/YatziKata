package org.kata.yatzy;

import java.util.Objects;

public class Yatzy {

    public static int chance(Roll roll) {
        return roll.sumDiceValues();
    }

    public static int ones(Roll roll) {
        return roll.sumSearchedOccurrence(1);
    }

    public static int twos(Roll roll) {
        return roll.sumSearchedOccurrence(2);
    }

    public static int threes(Roll roll) {
        return roll.sumSearchedOccurrence(3);
    }

    public static int fours(Roll roll) {
        return roll.sumSearchedOccurrence(4);
    }

    public static int fives(Roll roll) {
        return roll.sumSearchedOccurrence(5);
    }

    public static int sixes(Roll roll) {
        return roll.sumSearchedOccurrence(6);
    }

    public static int smallStraight(Roll roll) {
        return roll.isSmallStraight() ? 15 : 0;
    }

    public static int largeStraight(Roll roll) {
        return roll.isLargeStraight() ? 20 : 0;
    }

    public static int threeOfAKind(Roll roll) {
        return roll.getDieFaceForSearchedOccurrence(3) * 3;
    }

    public static int fourOfAKind(Roll roll) {
        return roll.getDieFaceForSearchedOccurrence(4) * 4;
    }

    public static int yatzy(Roll roll) {
        if (roll.isYatzy()) {
            return 50;
        } else {
            return 0;
        }
    }

    public static int scorePair(Roll roll) {
        return roll.findNPair(1) * 2;
    }

    public static int twoPair(Roll roll) {
        int fourOfAKind = fourOfAKind(roll);
        if (fourOfAKind != 0) {
            return fourOfAKind;
        }
        return roll.findNPair(2) * 2;
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