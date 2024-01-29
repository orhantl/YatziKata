package org.kata.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Roll {
    private List<Integer> dice;

    private Roll(int d1, int d2, int d3, int d4, int d5) {
        this.dice = Arrays.asList(d1, d2, d3, d4, d5);
        dice.sort(Comparator.reverseOrder());
    }

    public List<Integer> getDice() {
        return dice;
    }

    public static Roll of(int d1, int d2, int d3, int d4, int d5) {
        return new Roll(d1, d2, d3, d4, d5);
    }
}
