package com.minesweeper.converter;


import com.minesweeper.converter.CoordinateConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateConverterTest {

    CoordinateConverter coordinateConverter;

    @BeforeEach
    public void setup() {
        coordinateConverter = new CoordinateConverter();
    }

    @Test
    public void testConvertCoordinate_A1() {
        assertArrayEquals(new int[]{0, 0}, coordinateConverter.convertCoordinate("A1"));
    }

    @Test
    public void testConvertCoordinate_B2() {
        assertArrayEquals(new int[]{1, 1}, coordinateConverter.convertCoordinate("B2"));
    }

    @Test
    public void testConvertCoordinate_Z3() {
        assertArrayEquals(new int[]{25, 2}, coordinateConverter.convertCoordinate("Z3"));
    }

    @Test
    public void testInvalidCoordinateFormat_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinateConverter.convertCoordinate("");
        });
    }

    @Test
    public void testInvalidCoordinateFormat_LetterOnly() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinateConverter.convertCoordinate("A");
        });
    }

    @Test
    public void testInvalidCoordinateFormat_DigitBeforeLetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinateConverter.convertCoordinate("1A");
        });
    }

    @Test
    public void testInvalidCoordinateFormat_LettersOnly() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinateConverter.convertCoordinate("AA");
        });
    }
}


