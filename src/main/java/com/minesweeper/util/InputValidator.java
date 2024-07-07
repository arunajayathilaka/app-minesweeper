package com.minesweeper.util;

public class InputValidator {

    public boolean validateNumber(String input) {
        if (input == null) return false;
        return input.matches(Constants.NUMBER_REGEX);
    }

    public boolean validateMinGridInput(String input) {
        if (input == null) return false;
        return Integer.parseInt(input) >= Constants.MINIMUM_GRID_SIZE_INPUT;
    }

    public boolean validateMaxGridInput(String input) {
        if (input == null) return false;
        return Integer.parseInt(input) <= Constants.MAX_GRID_SIZE_INPUT;
    }

    public boolean validateNosOfMinesBasedOnGrid(int grid, String input) {
        float nosOfMines = Float.parseFloat(input);
        return (nosOfMines / (grid * grid)) * 100 < Constants.NOS_OF_MINES_RATIO;
    }

    public boolean validateMinNosOfMinesBasedOnGrid(String input) {
        int nosOfMines = Integer.parseInt(input);
        return nosOfMines > 0;
    }

    public boolean validateCoordinate(String input, String regex) {
        if (input == null) return false;
        return input.matches(regex);
    }

    public boolean validateCoordinateIsWithinGrid(int gridSize, int[] inputs) {
        if (inputs == null) return false;

        return gridSize > inputs[0] & gridSize > inputs[1];
    }

}
