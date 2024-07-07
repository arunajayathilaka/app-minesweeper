package com.minesweeper.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void testValidateNumber_ValidNumber() {
        assertTrue(inputValidator.validateNumber("123"));
    }

    @Test
    void testValidateNumber_InvalidNumber() {
        assertFalse(inputValidator.validateNumber("abc"));
    }

    @Test
    void testValidateNumber_Null() {
        assertFalse(inputValidator.validateNumber(null));
    }

    @Test
    void testValidateMinGridInput_ValidInput() {
        assertTrue(inputValidator.validateMinGridInput("5"));
    }

    @Test
    void testValidateMinGridInput_InvalidInput() {
        assertFalse(inputValidator.validateMinGridInput("1"));
    }

    @Test
    void testValidateMinGridInput_Null() {
        assertFalse(inputValidator.validateMinGridInput(null));
    }

    @Test
    void testValidateMaxGridInput_ValidInput() {
        assertTrue(inputValidator.validateMaxGridInput("10"));
    }

    @Test
    void testValidateMaxGridInput_InvalidInput() {
        assertFalse(inputValidator.validateMaxGridInput("15"));
    }

    @Test
    void testValidateMaxGridInput_Null() {
        assertFalse(inputValidator.validateMaxGridInput(null));
    }

    @Test
    void testValidateNosOfMinesBasedOnGrid_whenMinesBelow35Percent_pass() {
        assertTrue(inputValidator.validateNosOfMinesBasedOnGrid(5, "8"));
    }

    @Test
    void testValidateNosOfMinesBasedOnGrid_whenMinesAbove35Percent_failed() {
        assertFalse(inputValidator.validateNosOfMinesBasedOnGrid(5, "50"));
    }

    @Test
    void testValidateMinNosOfMinesBasedOnGrid_ValidInput() {
        assertTrue(inputValidator.validateMinNosOfMinesBasedOnGrid("1"));
    }

    @Test
    void testValidateMinNosOfMinesBasedOnGrid_InvalidInput() {
        assertFalse(inputValidator.validateMinNosOfMinesBasedOnGrid("0"));
    }

    @Test
    void testValidateCoordinate_ValidCoordinate() {
        assertTrue(inputValidator.validateCoordinate("A1", Constants.COORDINATE_INPUT_REGEX));
    }

    @Test
    void testValidateCoordinate_InvalidCoordinate() {
        assertFalse(inputValidator.validateCoordinate("@9", Constants.COORDINATE_INPUT_REGEX));
    }

    @Test
    void testValidateCoordinate_Null() {
        assertFalse(inputValidator.validateCoordinate(null, Constants.COORDINATE_INPUT_REGEX));
    }

    @Test
    void testValidateCoordinateIsWithinGrid_ValidCoordinate() {
        assertTrue(inputValidator.validateCoordinateIsWithinGrid(5, new int[]{2, 3}));
    }

    @Test
    void testValidateCoordinateIsWithinGrid_InvalidCoordinate() {
        assertFalse(inputValidator.validateCoordinateIsWithinGrid(5, new int[]{6, 2}));
    }

    @Test
    void testValidateCoordinateIsWithinGrid_NullInput() {
        assertFalse(inputValidator.validateCoordinateIsWithinGrid(5, null));
    }
}

