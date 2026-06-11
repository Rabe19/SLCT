package com.slct.tictactoe;

public class Board {

    private final Player[][] cells;

    public Board() {
        this.cells = new Player[3][3];
    }

    public boolean makeMove(int row, int column, Player player) {
        if (!isValidPosition(row, column)) {
            return false;
        }

        if (!isCellEmpty(row, column)) {
            return false;
        }

        cells[row][column] = player;
        return true;
    }

    public boolean isCellEmpty(int row, int column) {
        if (!isValidPosition(row, column)) {
            return false;
        }

        return cells[row][column] == null;
    }

    public Player getCell(int row, int column) {
        if (!isValidPosition(row, column)) {
            return null;
        }

        return cells[row][column];
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < 3 && column >= 0 && column < 3;
    }

    public String display() {
        StringBuilder builder = new StringBuilder();

        builder.append("▁▁▁▁▁▁").append(System.lineSeparator());

        for (int row = 0; row < 3; row++) {
            builder.append("|");

            for (int column = 0; column < 3; column++) {
                Player player = cells[row][column];
                builder.append(player == null ? " " : player.name());
                builder.append("|");
            }

            builder.append(System.lineSeparator());
        }

        builder.append("▔▔▔▔▔▔");

        return builder.toString();
    }
}
