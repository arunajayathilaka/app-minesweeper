package com.minesweeper.converter;

/**
 * This is an interface of coordinate converter,
 * can have multiple implementation based on requirement.
 */
public interface ICoordinateConverter {
    /**
     * Converter string coordinate to array of two (x, y) in 2 dimension array.
     *
     * @param coordinate string value of coordinate
     * @return int array
     */
    int[] convertCoordinate(String coordinate);

    /**
     * Get Regex value used for validation
     *
     * @return string value of regex
     */
    String getRegex();
}
