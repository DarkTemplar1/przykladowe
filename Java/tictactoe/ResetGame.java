package projekt;

import javax.swing.*;

public class ResetGame {
    public static void resetGame(int boardSize, JButton[][] buttons) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(null);
            }
        }
    }
}
