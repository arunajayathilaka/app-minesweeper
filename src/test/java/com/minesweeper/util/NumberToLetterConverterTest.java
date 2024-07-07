package com.minesweeper.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberToLetterConverterTest {

    @Test
    public void testValidNumbers() {
        assertEquals('A', NumberToLetterConverter.getLetterFromNumber(1));
        assertEquals('B', NumberToLetterConverter.getLetterFromNumber(2));
        assertEquals('C', NumberToLetterConverter.getLetterFromNumber(3));
        assertEquals('X', NumberToLetterConverter.getLetterFromNumber(24));
        assertEquals('Y', NumberToLetterConverter.getLetterFromNumber(25));
        assertEquals('Z', NumberToLetterConverter.getLetterFromNumber(26));
    }

    @Test
    public void testNumberLessThanOne() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberToLetterConverter.getLetterFromNumber(0);
        });

        assertEquals("Number must be between 1 and 26", exception.getMessage());
    }

    @Test
    public void testNumberGreaterThanTwentySix() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberToLetterConverter.getLetterFromNumber(27);
        });

        assertEquals("Number must be between 1 and 26", exception.getMessage());
    }

    @Test
    public void testNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberToLetterConverter.getLetterFromNumber(-5);
        });

        assertEquals("Number must be between 1 and 26", exception.getMessage());
    }
}


