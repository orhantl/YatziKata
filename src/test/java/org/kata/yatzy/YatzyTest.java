package org.kata.yatzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.kata.yatzy.Roll.of;

class YatzyTest {

    @Test
    void should_score_combination_of_chance() {
        assertEquals(15, Yatzy.chance(of(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(of(3, 3, 4, 5, 1)));
    }

    @Test
    void should_score_combination_of_ones() {
        assertEquals(1, Yatzy.ones(of(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(of(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(of(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(of(1, 2, 1, 1, 1)));
    }

    @Test
    void should_score_combination_of_twos() {
        assertEquals(4, Yatzy.twos(of(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(of(2, 2, 2, 2, 2)));
    }

    @Test
    void should_score_combination_of_threes() {
        assertEquals(6, Yatzy.threes(of(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(of(2, 3, 3, 3, 3)));
    }

    @Test
    void should_score_combination_of_fours() {
        assertEquals(12, Yatzy.fours(of(4,4,4,5,5)));
        assertEquals(8, Yatzy.fours(of(4,4,5,5,5)));
        assertEquals(4, Yatzy.fours(of(4,5,5,5,5)));
    }

    @Test
    void should_score_combination_of_fives() {
        assertEquals(10, Yatzy.fives(of(4,4,4,5,5)));
        assertEquals(15, Yatzy.fives(of(4,4,5,5,5)));
        assertEquals(20, Yatzy.fives(of(4,5,5,5,5)));
    }

    @Test
    void should_score_combination_of_sixes() {
        assertEquals(0, Yatzy.sixes(of(4,4,4,5,5)));
        assertEquals(6, Yatzy.sixes(of(4,4,6,5,5)));
        assertEquals(18, Yatzy.sixes(of(6,5,6,6,5)));
    }

    @Test
    void should_score_combination_of_yatzy() {
        assertEquals(50, Yatzy.yatzy(of(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.yatzy(of(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.yatzy(of(6, 6, 6, 6, 3)));
    }

    @Test
    void should_score_combination_of_onePair() {
        assertEquals(6, Yatzy.scorePair(of(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.scorePair(of(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.scorePair(of(5, 3, 6, 6, 5)));
    }

    @Test
    void should_score_combination_of_twoPairs() {
        assertEquals(16, Yatzy.twoPair(of(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPair(of(3, 3, 5, 5, 5)));
        assertEquals(12, Yatzy.twoPair(of(3, 3, 3, 3, 5)));
    }

    @Test
    void should_score_combination_of_threeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(of(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.threeOfAKind(of(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfAKind(of(3, 3, 3, 3, 5)));
        assertEquals(9, Yatzy.threeOfAKind(of(3, 3, 3, 3, 3)));
    }

    @Test
    void should_score_combination_of_fourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(of(3,3,3,3,5)));
        assertEquals(20, Yatzy.fourOfAKind(of(5,5,5,4,5)));
    }

    @Test
    void should_score_combination_of_smallStraight() {
        assertEquals(15, Yatzy.smallStraight(of(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(of(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.smallStraight(of(1, 2, 2, 4, 5)));
    }

    @Test
    void should_score_combination_of_largeStraight() {
        assertEquals(20, Yatzy.largeStraight(of(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(of(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.largeStraight(of(1, 2, 2, 4, 5)));
    }

    @Test
    void should_score_combination_of_fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}