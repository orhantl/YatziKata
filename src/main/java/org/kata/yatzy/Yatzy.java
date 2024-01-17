package org.kata.yatzy;

import java.util.List;

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
            return calculateScore(potentialPairs.get(0), 2);
        }
    }

    public static int twoPairs(DiceRoll dice) {
        List<Integer> potentialPairs = dice.findAndReverseOrderCombination(2);
        if (potentialPairs.size() < 2) {
            return 0;
        } else {
            return calculateScore(potentialPairs.get(0), 2)
                    + calculateScore(potentialPairs.get(1), 2);
        }
    }

    public static int threeOfAKind(DiceRoll dice) {
        List<Integer> potentialThreeOfAKind = dice.findAndReverseOrderCombination(3);
        if (potentialThreeOfAKind.isEmpty()) {
            return 0;
        } else {
            return calculateScore(potentialThreeOfAKind.get(0), 3);
        }
    }

    public static int fourOfAKind(DiceRoll dice) {
        List<Integer> potentialFourOfAKind = dice.findAndReverseOrderCombination(4);
        if (potentialFourOfAKind.isEmpty()) {
            return 0;
        } else {
            return calculateScore(potentialFourOfAKind.get(0), 4);
        }
    }

    public static int smallStraight(DiceRoll dice) {
        return dice.isSmallStraight() ? 15 : 0;
    }

    public static int largeStraight(DiceRoll dice) {
        return dice.isLargeStraight() ? 20 : 0;
    }

    public static int fullHouse(DiceRoll diceRoll) {
        if (diceRoll.isFullHouse()) {
            return diceRoll.getSum();
        } else {
            return 0;
        }
    }
}