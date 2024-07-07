package com.minesweeper.converter;

import com.minesweeper.converter.B26CoordinateConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class B26CoordinateConverterTest {

    B26CoordinateConverter b26CoordinateConverter;

    @BeforeEach
    public void setup() {
        b26CoordinateConverter = new B26CoordinateConverter();
    }


    @Test
    public void testConvertCoordinate_A1() {
        assertArrayEquals(new int[]{0, 0}, b26CoordinateConverter.convertCoordinate("A1"));
    }

    @Test
    public void testConvertCoordinate_Z1() {
        assertArrayEquals(new int[]{25, 0}, b26CoordinateConverter.convertCoordinate("Z1"));
    }

    @Test
    public void testConvertCoordinate_AA1() {
        assertArrayEquals(new int[]{26, 0}, b26CoordinateConverter.convertCoordinate("AA1"));
    }

    @Test
    public void testConvertCoordinate_AB1() {
        assertArrayEquals(new int[]{27, 0}, b26CoordinateConverter.convertCoordinate("AB1"));
    }

    @Test
    public void testConvertCoordinate_AZ1() {
        assertArrayEquals(new int[]{51, 0}, b26CoordinateConverter.convertCoordinate("AZ1"));
    }

    @Test
    public void testConvertCoordinate_BA1() {
        assertArrayEquals(new int[]{52, 0}, b26CoordinateConverter.convertCoordinate("BA1"));
    }

    @Test
    public void testConvertCoordinate_AA10() {
        assertArrayEquals(new int[]{26, 9}, b26CoordinateConverter.convertCoordinate("AA10"));
    }

    @Test
    public void testInvalidCoordinate_EmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("");
        });
    }

    @Test
    public void testInvalidCoordinate_NoDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("AA");
        });
    }

    @Test
    public void testInvalidCoordinate_NoLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("123");
        });
    }

    @Test
    public void testInvalidCoordinate_InvalidCharacter() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("A$1");
        });
    }

    @Test
    public void testInvalidCoordinate_ZeroNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("A0");
        });
    }

    @Test
    public void testInvalidCoordinate_NegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("A-1");
        });
    }

    @Test
    public void testInvalidCoordinate_LowerCaseLetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            b26CoordinateConverter.convertCoordinate("a1");
        });
    }
}

