package com.minesweeper;

import com.minesweeper.board.Board;
import com.minesweeper.board.IBoard;
import com.minesweeper.game.IMinesweeperGame;
import com.minesweeper.game.MinesweeperGame;
import com.minesweeper.converter.CoordinateConverter;
import com.minesweeper.util.InputPrompter;
import com.minesweeper.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper!\n");
        IMinesweeperGame game = createGame(scanner);

        while (true) {
            game.play();
            scanner.nextLine();
            restart(scanner);
        }
    }

    public static void restart(Scanner scanner) {
        IMinesweeperGame game = createGame(scanner);
        game.play();
    }

    private static IMinesweeperGame createGame(Scanner scanner) {
        InputPrompter inputPrompter = new InputPrompter(new InputValidator(), new CoordinateConverter());
        int gridSize = inputPrompter.gridSizePrompt(scanner);
        int mineCount = inputPrompter.getNosOFMinesPrompt(scanner, gridSize);

        IBoard board = new Board(gridSize, mineCount);
        return new MinesweeperGame(board, () -> inputPrompter.getCoordinatePrompt(scanner, gridSize));
    }
}