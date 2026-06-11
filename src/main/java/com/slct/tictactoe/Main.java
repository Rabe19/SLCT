package com.slct.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player currentPlayer = Player.X;

        System.out.println("Tic Tac Toe");
        System.out.println("Gib Zeile und Spalte von 0 bis 2 ein.");

        while (board.getGameState() == GameState.RUNNING) {
            System.out.println();
            System.out.println(board.display());
            System.out.println("Spieler " + currentPlayer + " ist dran.");

            System.out.print("Zeile: ");
            int row = scanner.nextInt();

            System.out.print("Spalte: ");
            int column = scanner.nextInt();

            boolean moveWasSuccessful = board.makeMove(row, column, currentPlayer);

            if (!moveWasSuccessful) {
                System.out.println("Ungültiger Zug. Bitte nochmal versuchen.");
                continue;
            }

            currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
        }

        System.out.println();
        System.out.println(board.display());

        GameState result = board.getGameState();

        if (result == GameState.X_WON) {
            System.out.println("Spieler X hat gewonnen!");
        } else if (result == GameState.O_WON) {
            System.out.println("Spieler O hat gewonnen!");
        } else {
            System.out.println("Unentschieden!");
        }

        scanner.close();
    }
}