package com.minesweeper.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testInitialCellState() {
        assertFalse(cell.isMine());
        assertFalse(cell.isRevealed());
        assertEquals(0, cell.getAdjacentMines());
    }

    @Test
    public void testSetMine() {
        cell.setMine();
        assertTrue(cell.isMine());
    }

    @Test
    public void testReveal() {
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testSetAdjacentMines() {
        cell.setAdjacentMines(3);
        assertEquals(3, cell.getAdjacentMines());
    }

    @Test
    public void testDisplay_whenNonReveal_returnUnderscore() {
        assertEquals('_', cell.display());
    }

    @Test
    public void testDisplay_whenReveal_returnZero() {
        cell.reveal();
        assertEquals('0', cell.display());
    }

    @Test
    public void testDisplay_whenSetAdjacent_returnValue() {
        cell.reveal();
        cell.setAdjacentMines(2);
        assertEquals('2', cell.display());
    }

    @Test
    public void testDisplay_whenSetMine_returnStar() {
        cell.reveal();
        cell.setMine();
        assertEquals('*', cell.display());
    }
}

