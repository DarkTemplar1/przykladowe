package projekt;

import javax.swing.*;
import java.util.Random;

public class BotMove {
    static void botMove(TicTacToeGUI game) {
        if (!IsBoradFull.isBoardFull(game.boardSize, game.buttons)) {
            Random rand = new Random();
            int row, col;
            do {
                row = rand.nextInt(game.boardSize);
                col = rand.nextInt(game.boardSize);
            } while (!game.buttons[row][col].getText().isEmpty());

            game.buttons[row][col].setText(game.player2Sign);
            game.buttons[row][col].setEnabled(false);

            if (CheckWin.checkWin(game)) {
                String message = game.againstBot ? "The bot wins!" : "Player 2 wins!";
                JOptionPane.showMessageDialog(game, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                ResetGame.resetGame(game.boardSize, game.buttons);
            } else if (IsBoradFull.isBoardFull(game.boardSize, game.buttons)) {
                JOptionPane.showMessageDialog(game, "It's a tie!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                ResetGame.resetGame(game.boardSize, game.buttons);
            } else {
                game.xTurn = !game.xTurn;
            }
        }
    }
}
