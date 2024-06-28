package projekt;

import javax.swing.*;

public class IsBoradFull {
    static boolean isBoardFull(int boardSize, JButton[][] buttons) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
