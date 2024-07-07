package com.minesweeper.game;

/**
 * Used this interface for loosely coupled prompter with Game implementation.
 */
@FunctionalInterface
public interface RevealedSquareInputPrompter {
    /**
     * Get input value.
     *
     * @return int array
     */
    int[] getValue();
}
