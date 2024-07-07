package com.minesweeper.converter;

import com.minesweeper.util.Constants;

/**
 * This is converter only supports for only single letter.
 * Format should be ^[A-Z][1-9]+$ (One letter and multiple digits can accommodate)
 */
public class CoordinateConverter implements ICoordinateConverter {

    /**
     * Converts a letter-number coordinate format (e.g., "A1", "B2") into grid coordinates.
     *
     * @param coordinate The coordinate in letter-number format (e.g., "A1").
     * @return An array of two integers representing row and column indices.
     * @throws IllegalArgumentException if the coordinate format is invalid.
     */
    @Override
    public int[] convertCoordinate(String coordinate) {
        if (coordinate == null || coordinate.length() < 2) {
            throw new IllegalArgumentException("Invalid coordinate format");
        }

        char letter = Character.toUpperCase(coordinate.charAt(0));
        int number = Integer.parseInt(coordinate.substring(1));

        if (letter < 'A' || letter > 'Z' || number < 1) {
            throw new IllegalArgumentException("Invalid coordinate format");
        }

        int row = letter - 'A';
        int column = number - 1;


        return new int[]{row, column};
    }

    @Override
    public String getRegex() {
        return Constants.COORDINATE_INPUT_REGEX;
    }
}

