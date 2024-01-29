package org.kata.yatzy;

public class Yatzy {

    private static final int SMALL_STRAIGHT_POINT = 15;
    private static final int LARGE_STRAIGHT_POINTS = 20;
    private static final int YATZY_POINTS = 50;

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
        return roll.isSmallStraight() ? SMALL_STRAIGHT_POINT : 0;
    }

    public static int largeStraight(Roll roll) {
        return roll.isLargeStraight() ? LARGE_STRAIGHT_POINTS : 0;
    }

    public static int threeOfAKind(Roll roll) {
        return roll.getDieFaceForSearchedOccurrence(3) * 3;
    }

    public static int fourOfAKind(Roll roll) {
        return roll.getDieFaceForSearchedOccurrence(4) * 4;
    }

    public static int yatzy(Roll roll) {
        if (roll.isYatzy()) {
            return YATZY_POINTS;
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

    public static int fullHouse(Roll roll) {
        if (!roll.isFullHouse()) {
            return 0;
        }
        else {
            return threeOfAKind(roll) + scorePair(roll);
        }
    }
}