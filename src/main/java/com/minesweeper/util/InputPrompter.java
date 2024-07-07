package com.minesweeper.util;

import com.minesweeper.converter.ICoordinateConverter;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 */
public class InputPrompter {
    InputValidator inputValidator;
    ICoordinateConverter coordinateConverter;

    public InputPrompter(InputValidator inputValidator, ICoordinateConverter coordinateConverter) {
        this.inputValidator = inputValidator;
        this.coordinateConverter = coordinateConverter;
    }

    public int gridSizePrompt(Scanner scanner) {
        String gridSizeInput;
        boolean isInputValid;
        boolean isInMinBoundValid = false;
        boolean isInMaxBoundValid = false;
        do {
            PrintStream out = new PrintStream(System.out);
            out.println("Enter grid size: (e.g. 4 for a 4x4 grid)");
            gridSizeInput = scanner.nextLine();

            isInputValid = inputValidator.validateNumber(gridSizeInput);
            if (!isInputValid) {
                out.println("Incorrect input.\n");
                continue;
            }

            isInMinBoundValid = inputValidator.validateMinGridInput(gridSizeInput);
            if (!isInMinBoundValid) {
                out.println("Minimum size of grid is " + Constants.MINIMUM_GRID_SIZE_INPUT + "\n");
                continue;
            }

            isInMaxBoundValid = inputValidator.validateMaxGridInput(gridSizeInput);
            if (!isInMaxBoundValid) {
                out.println("Maximum size of grid is " + Constants.MAX_GRID_SIZE_INPUT + "\n");
            }
        } while (!isInputValid || !isInMinBoundValid || !isInMaxBoundValid);

        return Integer.parseInt(gridSizeInput);
    }

    public int getNosOFMinesPrompt(Scanner scanner, int gridSize) {
        String nosOfMines;
        boolean isInputValid;
        boolean isInMinBoundValid = false;
        boolean isInMaxBoundValid = false;
        do {
            PrintStream out = new PrintStream(System.out);
            out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares):");
            nosOfMines = scanner.nextLine();

            isInputValid = inputValidator.validateNumber(nosOfMines);
            if (!isInputValid) {
                out.println("Incorrect input.\n");
                continue;
            }

            isInMinBoundValid = inputValidator.validateMinNosOfMinesBasedOnGrid(nosOfMines);
            if (!isInMinBoundValid) {
                out.println("There must be at least 1 mine.\n");
                continue;
            }

            isInMaxBoundValid = inputValidator.validateNosOfMinesBasedOnGrid(gridSize, nosOfMines);
            if (!isInMaxBoundValid) {
                out.println("Maximum number is " + Constants.NOS_OF_MINES_RATIO + "% of total squares.\n");
            }
        } while (!isInputValid || !isInMinBoundValid || !isInMaxBoundValid);

        return Integer.parseInt(nosOfMines);
    }

    public int[] getCoordinatePrompt(Scanner scanner, int gridSize) {
        String coordinate;
        boolean isInputValid;
        boolean isInputIsWithinBoundValid = false;
        do {
            PrintStream out = new PrintStream(System.out);
            out.print("Select a square to reveal (e.g. A1): ");
            coordinate = scanner.nextLine();
            isInputValid = inputValidator.validateCoordinate(coordinate, coordinateConverter.getRegex());
            if (!isInputValid) {
                out.println("Incorrect input.");
                continue;
            }

            int[] ints = coordinateConverter.convertCoordinate(coordinate);

            isInputIsWithinBoundValid = inputValidator.validateCoordinateIsWithinGrid(gridSize, ints);
            if (!isInputIsWithinBoundValid) {
                out.println("input is not within bound.");
            }

        } while (!isInputValid || !isInputIsWithinBoundValid);

        return coordinateConverter.convertCoordinate(coordinate);

    }
}
