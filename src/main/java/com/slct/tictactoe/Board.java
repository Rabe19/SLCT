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

    public GameState getGameState() {
        if (hasPlayerWon(Player.X)) {
            return GameState.X_WON;
        }

        if (hasPlayerWon(Player.O)) {
            return GameState.O_WON;
        }

        if (isFull()) {
            return GameState.DRAW;
        }

        return GameState.RUNNING;
    }

    private boolean hasPlayerWon(Player player) {
        return hasWinningRow(player)
                || hasWinningColumn(player)
                || hasWinningDiagonal(player);
    }

    private boolean hasWinningRow(Player player) {
        for (int row = 0; row < 3; row++) {
            if (cells[row][0] == player
                    && cells[row][1] == player
                    && cells[row][2] == player) {
                return true;
            }
        }

        return false;
    }

    private boolean hasWinningColumn(Player player) {
        for (int column = 0; column < 3; column++) {
            if (cells[0][column] == player
                    && cells[1][column] == player
                    && cells[2][column] == player) {
                return true;
            }
        }

        return false;
    }

    private boolean hasWinningDiagonal(Player player) {
        boolean topLeftToBottomRight = cells[0][0] == player
                && cells[1][1] == player
                && cells[2][2] == player;

        boolean topRightToBottomLeft = cells[0][2] == player
                && cells[1][1] == player
                && cells[2][0] == player;

        return topLeftToBottomRight || topRightToBottomLeft;
    }

    private boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (cells[row][column] == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
