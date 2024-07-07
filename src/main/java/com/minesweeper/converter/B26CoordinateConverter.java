package com.minesweeper.converter;

import com.minesweeper.util.Constants;

/**
 * This is converter only supports for only multiple letters.
 * Format should be ^[A-Z]+[1-9]+[0-9]?$ (multiple letter and multiple digits can accommodate)
 */
public class B26CoordinateConverter implements ICoordinateConverter {

    public static final String LETTER_NUMBER_REGEX = "(?<=\\D)(?=\\d)";

    /**
     * Converts a letter-number coordinate format (e.g., "AA1", "AB2") into grid coordinates.
     *
     * @param coordinate The coordinate in letter-number format (e.g., "A1").
     *                   An array of two integers representing row and column indices.
     * @throws IllegalArgumentException if the coordinate format is invalid.
     */
    @Override
    public int[] convertCoordinate(String coordinate) {

        if (!coordinate.matches("^[A-Z]+[1-9]+[0-9]?$")) {
            throw new IllegalArgumentException("Invalid coordinate format");
        }

        String[] coordinateArr = coordinate.split(LETTER_NUMBER_REGEX);

        char[] letters = coordinateArr[0].toCharArray();
        int row = 0;

        int number = Integer.parseInt(coordinateArr[1]);

        for (char l : letters) {
            if (l < 'A' || l > 'Z' || number < 1) {
                throw new IllegalArgumentException("Invalid coordinate format");
            }
            int value = l - 'A' + 1;
            row = row * 26 + value;
        }

        int column = number - 1;


        return new int[]{row - 1, column};
    }

    @Override
    public String getRegex() {
        return Constants.BASE26_COORDINATE_INPUT_REGEX;
    }
}
