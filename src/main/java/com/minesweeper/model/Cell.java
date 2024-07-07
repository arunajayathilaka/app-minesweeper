package com.minesweeper.model;

/**
 * Manages the state of a single cell.
 */
public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine() {
        this.isMine = true;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        this.isRevealed = true;
    }


    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public char display() {
        if (isRevealed) {
            if (isMine) return '*';
            return adjacentMines > 0 ? (char) ('0' + adjacentMines) : '0';
        } else {
            return '_';
        }
    }
}

