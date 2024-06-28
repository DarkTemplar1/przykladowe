package projekt;

public class DrawWinningLine {
    static void drawWinningLine(TicTacToeGUI ticTacToeGUI, int startX, int startY, int endX, int endY, int typ) {

        if (startX < 0) startX = 0;
        if (startY < 0) startY = 0;
        if (endX >= ticTacToeGUI.boardSize) endX = ticTacToeGUI.boardSize;
        if (endY >= ticTacToeGUI.boardSize) endY = ticTacToeGUI.boardSize;

        switch (typ) {
            case Static.ROWS_OR_COLUMNS:
                for (int i = startX; i <= endX; i++) {
                    for (int j = startY; j <= endY; j++) {
                        ticTacToeGUI.buttons[i][j].setBackground(ticTacToeGUI.winningLineColor);
                    }
                }
                break;
            case Static.DIAGONAL_RIGHT_TO_DOWN:
                for (int i = startX, j = startY; i <= endX && j <= endY; i++, j++) {
                    ticTacToeGUI.buttons[i][j].setBackground(ticTacToeGUI.winningLineColor);
                }
                break;
            case Static.DIAGONAL_RIGHT_TO_TOP:
                for (int i = startX, j = endY; i <= endX && j >= startY; i++, j--) {
                    ticTacToeGUI.buttons[i][j].setBackground(ticTacToeGUI.winningLineColor);
                }
            default:
                break;
        }

    }
}
