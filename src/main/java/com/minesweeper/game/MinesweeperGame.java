package com.minesweeper.game;

import com.minesweeper.board.IBoard;

/**
 * Manages the game flow, including user input and game state (win/loss).
 */
public class MinesweeperGame implements IMinesweeperGame {
    private final IBoard board;
    private boolean gameOver;

    private final RevealedSquareInputPrompter inputPrompter;

    public MinesweeperGame(IBoard board, RevealedSquareInputPrompter inputPrompter) {
        this.board = board;
        this.gameOver = false;
        this.inputPrompter = inputPrompter;
    }

    @Override
    public void play() {
        while (!gameOver) {
            board.display();
            int[] ints = this.inputPrompter.getValue();
            handleUserInput(ints[0], ints[1]);
        }
    }

    void handleUserInput(int row, int col) {
        if (board.isRevealed(row, col)) {
            System.out.println("Already revealed, plz enter another.");
        } else if (board.uncover(row, col)) {
            gameOver = true;
            System.out.println("Oh no, you detonated a mine! Game over.");
            System.out.println("Press any key to play again...");
            // board.revealAllMines();
            // board.display();
        } else if (board.isGameWon()) {
            gameOver = true;
            System.out.println("This square contains " + board.getAdjacentValue(row, col) + " adjacent mines.");
            board.display();
            System.out.println("Congratulations, you have won the game!");
            System.out.println("Press any key to play again...");
            // board.revealAllMines();
        } else {
            System.out.println("This square contains " + board.getAdjacentValue(row, col) + " adjacent mines.");
        }
    }

}

