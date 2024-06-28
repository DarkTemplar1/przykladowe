package projekt;

public class CheckWin {
    static boolean checkWin(TicTacToeGUI game) {
        String[][] board = new String[game.boardSize][game.boardSize];

        for (int i = 0; i < game.boardSize; i++) {
            for (int j = 0; j < game.boardSize; j++) {
                board[i][j] = game.buttons[i][j].getText();
            }
        }

        // Check rows
        for (int i = 0; i < game.boardSize; i++) {
            int count = 1;
            for (int j = 0; j < game.boardSize - 1; j++) {
                if (!board[i][j].isEmpty() && board[i][j].equals(board[i][j + 1]))
                    count++;
                if (count == game.lineToWin) {
                    DrawWinningLine.drawWinningLine(game, i, j - game.lineToWin + 2, i, j + 1, Static.ROWS_OR_COLUMNS);
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < game.boardSize; i++) {
            int count = 1;
            for (int j = 0; j < game.boardSize - 1; j++) {
                if (!board[j][i].isEmpty() && board[j][i].equals(board[j + 1][i])) {
                    count++;
                }
                if (count == game.lineToWin) {
                    DrawWinningLine.drawWinningLine(game, j - game.lineToWin + 2, i, j + 1, i, Static.ROWS_OR_COLUMNS);
                    return true;
                }
            }
        }

        // Check diagonals

        for (int i0 = 0; i0 < game.boardSize; i0++)
            for (int j0 = 0; j0 < game.boardSize; j0++) {
                int count = 1;
                for (int i = i0, j = j0; i < game.boardSize - 1 && j < game.boardSize - 1; i++, j++) {
                    if (!board[i][j].isEmpty() && board[i][j].equals(board[i + 1][j + 1])) {
                        count++;
                    }
                    if (count == game.lineToWin) {
                        DrawWinningLine.drawWinningLine(game, i - game.lineToWin + 2, j - game.lineToWin + 2, i + 1, j + 1, Static.DIAGONAL_RIGHT_TO_DOWN);
                        return true;
                    }
                }
            }


        for (int i0 = game.lineToWin - 1; i0 < game.boardSize; i0++)
            for (int j0 = 0; j0 < game.boardSize; j0++) {
                int count = 1;
                for (int i = i0, j = j0; i > 0 && j < game.boardSize - 1; i--, j++) {
                    if (!board[i][j].isEmpty() && board[i][j].equals(board[i - 1][j + 1])) {
                        count++;
                    }
                    if (count == game.lineToWin) {
                        DrawWinningLine.drawWinningLine(game, i - 1, j - game.lineToWin + 2, i - 1 + game.lineToWin, j + 1, Static.DIAGONAL_RIGHT_TO_TOP);
                        return true;
                    }
                }

            }
        return false;
    }
}
