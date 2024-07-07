package com.minesweeper.board;

import com.minesweeper.model.Cell;
import com.minesweeper.util.NumberToLetterConverter;

import java.util.Random;

/**
 * Implementation of Board,
 * Manages the grid of cells, including initialization, mine placement, uncovering cells, and displaying the grid.
 */
public class Board implements IBoard {
    private final Cell[][] cells;
    private final int gridSize;
    private final int mineCount;
    private int uncoveredCells;

    public Board(int gridSize, int mineCount) {
        this.gridSize = gridSize;
        this.mineCount = mineCount;
        this.cells = new Cell[gridSize][gridSize];
        this.uncoveredCells = 0;
        initialize();
    }

    @Override
    public void initialize() {
        initializeCells();
        placeMines();
        calculateAdjacentMines();
    }

    private void initializeCells() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < mineCount) {
            int row = random.nextInt(gridSize);
            int col = random.nextInt(gridSize);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine();
                minesPlaced++;
            }
        }
    }

    private void calculateAdjacentMines() {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (cells[i][j].isMine()) {
                    continue;
                }
                int mineCount = 0;
                for (int k = 0; k < 8; k++) {
                    int newRow = i + dx[k];
                    int newCol = j + dy[k];
                    if (isValidCoordinate(newRow, newCol) && cells[newRow][newCol].isMine()) {
                        mineCount++;
                    }
                }
                cells[i][j].setAdjacentMines(mineCount);
            }
        }
    }

    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < gridSize && col >= 0 && col < gridSize;
    }

    @Override
    public boolean uncover(int row, int col) {
        if (!isValidCoordinate(row, col) || cells[row][col].isRevealed()) {
            return false;
        }
        cells[row][col].reveal();
        uncoveredCells++;

        if (cells[row][col].isMine()) {
            return true; // Hit a mine
        }

        if (cells[row][col].getAdjacentMines() == 0) {
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
            for (int i = 0; i < 8; i++) {
                uncover(row + dx[i], col + dy[i]);
            }
        }

        return false;
    }

    @Override
    public boolean isGameWon() {
        return uncoveredCells == gridSize * gridSize - mineCount;
    }

    @Override
    public void revealAllMines() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (cells[i][j].isMine()) {
                    cells[i][j].reveal();
                }
            }
        }
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("Here is your updated minefield:");
        System.out.print("   ");
        for (int i = 0; i < gridSize; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < gridSize; i++) {
            System.out.print(NumberToLetterConverter.getLetterFromNumber(i + 1) + " ");
            if (i < 10) System.out.print(" ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(cells[i][j].display() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int getAdjacentValue(int row, int col) {
        return cells[row][col].getAdjacentMines();
    }

    @Override
    public boolean isRevealed(int row, int col) {
        return cells[row][col].isRevealed();
    }
}

