package com.minesweeper.board;

/**
 * Defines the operations related to the game board.
 */
public interface IBoard {
    /**
     * initialization of board
     */
    void initialize();

    /**
     * logic that help to uncover cells
     * @param row number
     * @param col number
     * @return true, false
     */
    boolean uncover(int row, int col);

    /**
     * is game won
     * @return true, false
     */
    boolean isGameWon();

    /**
     * reveal all mine
     */
    void revealAllMines();

    /**
     * display the grid.
     */
    void display();

    /**
     * Gets adjacent values of particular cell.
     * @param row row number
     * @param col column number
     * @return adjacent value
     */
    int getAdjacentValue(int row, int col);

    /**
     * check particular cell revealed or not
     * @param row row number
     * @param col column number
     * @return true, false
     */
    boolean isRevealed(int row, int col);
}

