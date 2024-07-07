package com.minesweeper.game;

import com.minesweeper.board.IBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class MinesweeperGameTest {
    private MinesweeperGame game;
    private IBoard board;

    @BeforeEach
    public void setUp() {
        board = Mockito.mock(IBoard.class);
        game = new MinesweeperGame(board, () -> new int[]{1,3});
    }

    @Test
    public void testPlayGameWin() {
        Mockito.when(board.uncover(Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
        Mockito.when(board.isGameWon()).thenReturn(true);

        game.handleUserInput(0, 0);

        Mockito.verify(board).display();
    }

    @Test
    public void testPlayGameLose() {
        Mockito.when(board.uncover(Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);

        game.handleUserInput(0, 0);

        Mockito.verify(board, Mockito.times(0)).display();
    }
}

