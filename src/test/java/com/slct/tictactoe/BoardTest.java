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
}