package com.minesweeper.util;

public class NumberToLetterConverter {
    public static char getLetterFromNumber(int number) {
        if (number < 1 || number > 26) {
            throw new IllegalArgumentException("Number must be between 1 and 26");
        }
        return (char) ('A' + number - 1);
    }
}
