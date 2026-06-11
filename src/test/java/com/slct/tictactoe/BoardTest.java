package com.slct.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldPlaceSymbolWhenCellIsEmpty() {
        Board board = new Board();

        boolean result = board.makeMove(1, 1, Player.X);

        assertTrue(result);
        assertEquals(Player.X, board.getCell(1, 1));
    }

    @Test
    void shouldNotPlaceSymbolWhenCellIsAlreadyTaken() {
        Board board = new Board();
        board.makeMove(1, 1, Player.X);

        boolean result = board.makeMove(1, 1, Player.O);

        assertFalse(result);
        assertEquals(Player.X, board.getCell(1, 1));
    }

    @Test
    void shouldRejectMoveWithInvalidRow() {
        Board board = new Board();

        boolean result = board.makeMove(3, 1, Player.X);

        assertFalse(result);
    }

    @Test
    void shouldRejectMoveWithInvalidColumn() {
        Board board = new Board();

        boolean result = board.makeMove(1, -1, Player.X);

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenCellIsEmpty() {
        Board board = new Board();

        boolean result = board.isCellEmpty(0, 0);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenCellIsNotEmpty() {
        Board board = new Board();
        board.makeMove(0, 0, Player.X);

        boolean result = board.isCellEmpty(0, 0);

        assertFalse(result);
    }

    @Test
    void shouldDisplayEmptyBoard() {
        Board board = new Board();

        String result = board.display();

        String expected = String.join(System.lineSeparator(),
                "▁▁▁▁▁▁",
                "| | | |",
                "| | | |",
                "| | | |",
                "▔▔▔▔▔▔"
        );

        assertEquals(expected, result);
    }

    @Test
    void shouldDisplayBoardWithPlacedSymbol() {
        Board board = new Board();
        board.makeMove(1, 1, Player.X);

        String result = board.display();

        String expected = String.join(System.lineSeparator(),
                "▁▁▁▁▁▁",
                "| | | |",
                "| |X| |",
                "| | | |",
                "▔▔▔▔▔▔"
        );

        assertEquals(expected, result);
    }

    @Test
    void shouldDisplayBoardWithBothPlayersSymbols() {
        Board board = new Board();
        board.makeMove(1, 1, Player.X);
        board.makeMove(1, 0, Player.O);

        String result = board.display();

        String expected = String.join(System.lineSeparator(),
                "▁▁▁▁▁▁",
                "| | | |",
                "|O|X| |",
                "| | | |",
                "▔▔▔▔▔▔"
        );

        assertEquals(expected, result);
    }

    @Test
    void shouldNotDisplayBoardWithoutPlacedSymbol() {
        Board board = new Board();
        board.makeMove(0, 0, Player.X);

        String result = board.display();

        String emptyBoard = String.join(System.lineSeparator(),
                "▁▁▁▁▁▁",
                "| | | |",
                "| | | |",
                "| | | |",
                "▔▔▔▔▔▔"
        );

        assertNotEquals(emptyBoard, result);
    }
}