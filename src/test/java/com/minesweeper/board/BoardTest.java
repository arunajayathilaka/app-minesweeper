package com.minesweeper.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BoardTest {
    private Board board;
    private final int gridSize = 5;
    private final int mineCount = 5;

    @BeforeEach
    public void setUp() {
        board = new Board(gridSize, mineCount);
    }

    @Test
    void testInitialize() {
        board.initialize();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board.isRevealed(i, j)) {
                    fail("Board should be initialized with all cells hidden");
                }
            }
        }
    }

    @Test
    void testUncover() {
        board.initialize();
        int initialUncoveredCells = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board.isRevealed(i, j)) {
                    initialUncoveredCells++;
                }
            }
        }
        assertEquals(0, initialUncoveredCells, "Initially, no cells should be uncovered");

        // Ensure uncovering a mine returns true
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board.uncover(i, j)) {
                    assertTrue(board.isRevealed(i, j), "Mine cell should be revealed");
                    return;
                }
            }
        }
        fail("No mines were uncovered, the test might not be valid if mines are not correctly placed");
    }

    @Test
    public void testUncover_IsGameWon() {
        int uncoveredCells = 0;
        board.initialize();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (!board.uncover(i, j)) {
                    uncoveredCells++;
                }
            }
        }
        assertEquals(gridSize * gridSize - mineCount, uncoveredCells, "The game should not be won if a mine is uncovered");
    }

    @Test
    void testRevealAllMines() {
        board.initialize();
        int revealedMines = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board.uncover(i, j)) {
                    if (board.isRevealed(i, j)) {
                        revealedMines++;
                    }
                }
            }
        }
        assertEquals(mineCount, revealedMines, "All mines should be revealed");
    }
}

