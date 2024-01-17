package org.kata.yatzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void test_chance_score() {
        assertEquals(15, Yatzy.chance(new DiceRoll(2,3,4,5,1)));
        assertEquals(16, Yatzy.chance(new DiceRoll(3,3,4,5,1)));
    }

    @Test
    public void test_yatzy_score() {
        assertEquals(50, Yatzy.yatzy(new DiceRoll(4,4,4,4,4)));
        assertEquals(50, Yatzy.yatzy(new DiceRoll(6,6,6,6,6)));
        assertEquals(0, Yatzy.yatzy(new DiceRoll(6,6,6,6,3)));
    }

    @Test
    public void test_ones_score() {
        assertEquals(1, Yatzy.ones(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new DiceRoll(1,2,1,4,5)));
        assertEquals(0, Yatzy.ones(new DiceRoll(6,2,2,4,5)));
        assertEquals(4, Yatzy.ones(new DiceRoll(1,2,1,1,1)));
    }

    @Test
    public void test_twos_score() {
        assertEquals(4, Yatzy.twos(new DiceRoll(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new DiceRoll(2,2,2,2,2)));
    }

    @Test
    public void test_threes_score() {
        assertEquals(6, Yatzy.threes(new DiceRoll(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new DiceRoll(2,3,3,3,3)));
    }

    @Test
    public void test_fours_score() {
        assertEquals(12, Yatzy.fours(new DiceRoll(4,4,4,5,5)));
        assertEquals(8, Yatzy.fours(new DiceRoll(4,4,5,5,5)));
        assertEquals(4, Yatzy.fours(new DiceRoll(4,5,5,5,5)));
    }

    @Test
    public void test_fives_score() {
        assertEquals(10, Yatzy.fives(new DiceRoll(4,4,4,5,5)));
        assertEquals(15, Yatzy.fives(new DiceRoll(4,4,5,5,5)));
        assertEquals(20, Yatzy.fives(new DiceRoll(4,5,5,5,5)));
    }

    @Test
    public void test_sixes_score() {
        assertEquals(0, Yatzy.sixes(new DiceRoll(4,4,4,5,5)));
        assertEquals(6, Yatzy.sixes(new DiceRoll(4,4,6,5,5)));
        assertEquals(18, Yatzy.sixes(new DiceRoll(6,5,6,6,5)));
    }

    @Test
    public void test_onePair_score() {
        assertEquals(6, Yatzy.onePair(new DiceRoll(3,4,3,5,6)));
        assertEquals(10, Yatzy.onePair(new DiceRoll(5,3,3,3,5)));
        assertEquals(12, Yatzy.onePair(new DiceRoll(5,3,6,6,5)));
        assertEquals(0, Yatzy.onePair(new DiceRoll(1,2,3,4,5)));
    }

    @Test
    public void test_twoPair_score() {
        assertEquals(16, Yatzy.twoPairs(new DiceRoll(3,3,5,4,5)));
        assertEquals(16, Yatzy.twoPairs(new DiceRoll(3,3,5,5,5)));
        assertEquals(6, Yatzy.twoPairs(new DiceRoll(1,1,2,2,2)));
        assertEquals(8, Yatzy.twoPairs(new DiceRoll(1,1,2,3,3)));
        assertEquals(0, Yatzy.twoPairs(new DiceRoll(1,2,3,4,5)));
        // TODO ask if two pairs score like a four of a kind ? -> 4 io 0 if dice face is 1
       assertEquals(0, Yatzy.twoPairs(new DiceRoll(1,1,1,1,2)));
    }

    @Test
    public void test_threeOfAKind_score()
    {
        assertEquals(9, Yatzy.threeOfAKind(new DiceRoll(3,3,3,4,5)));
        assertEquals(15, Yatzy.threeOfAKind(new DiceRoll(5,3,5,4,5)));
        assertEquals(9, Yatzy.threeOfAKind(new DiceRoll(3,3,3,3,5)));
        assertEquals(0, Yatzy.threeOfAKind(new DiceRoll(1,2,3,4,5)));
    }

    @Test
    public void test_fourOfAKind_score() {
        assertEquals(12, Yatzy.fourOfAKind(new DiceRoll(3,3,3,3,5)));
        assertEquals(20, Yatzy.fourOfAKind(new DiceRoll(5,5,5,4,5)));
        assertEquals(8, Yatzy.fourOfAKind(new DiceRoll(2,2,2,2,5)));
        assertEquals(0, Yatzy.fourOfAKind(new DiceRoll(3,3,3,5,5)));
        assertEquals(0, Yatzy.fourOfAKind(new DiceRoll(1,2,3,4,5)));
    }

    @Test
    public void test_smallStraight_score() {
        assertEquals(15, Yatzy.smallStraight(new DiceRoll(1,2,3,4,5)));
        assertEquals(15, Yatzy.smallStraight(new DiceRoll(2,3,4,5,1)));
        assertEquals(0, Yatzy.smallStraight(new DiceRoll(1,2,2,4,5)));
    }

    @Test
    public void test_largeStraight_score() {
        assertEquals(20, Yatzy.largeStraight(new DiceRoll(6,2,3,4,5)));
        assertEquals(20, Yatzy.largeStraight(new DiceRoll(2,3,4,5,6)));
        assertEquals(0, Yatzy.largeStraight(new DiceRoll(1,2,2,4,5)));
    }

    @Test
    public void test_fullHouse_score() {
        assertEquals(18, Yatzy.fullHouse(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(0, Yatzy.fullHouse(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(8, Yatzy.fullHouse(new DiceRoll(1, 1, 2, 2, 2)));
        assertEquals(0, Yatzy.fullHouse(new DiceRoll(2, 2, 3, 3, 4)));
        assertEquals(0, Yatzy.fullHouse(new DiceRoll(4, 4, 4, 4, 4)));
    }
}