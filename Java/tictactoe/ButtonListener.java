package projekt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonListener implements ActionListener {
    private final TicTacToeGUI game;

    public ButtonListener(TicTacToeGUI game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getText().isEmpty()) {
            button.setText(game.xTurn ? game.player1Sign : game.player2Sign);
            button.setEnabled(false);

            if (CheckWin.checkWin(game)) {
                String message = game.xTurn ? "Player 1 wins!" : "Player 2 wins!";
                JOptionPane.showMessageDialog(game, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                ResetGame.resetGame(game.boardSize, game.buttons);
            } else if (IsBoradFull.isBoardFull(game.boardSize, game.buttons)) {
                JOptionPane.showMessageDialog(game, "It's a tie!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                ResetGame.resetGame(game.boardSize, game.buttons);
            } else if (game.againstBot) {
                game.xTurn = !game.xTurn;
                BotMove.botMove(game);
            } else {
                game.xTurn = !game.xTurn;
            }
        }
    }
}
