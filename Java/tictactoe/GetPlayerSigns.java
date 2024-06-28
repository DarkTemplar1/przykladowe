package projekt;

import javax.swing.*;

public class GetPlayerSigns {
    static void getPlayerSigns(TicTacToeGUI game) {
        int option = JOptionPane.showOptionDialog(null, "Choose Sign Type", "Sign Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Standard (X, O)", "Customize"}, null);

        if (option == JOptionPane.YES_OPTION) {
            game.player1Sign = Static.DEFAULT_SIGN_PLAYER1;
            game.player2Sign = Static.DEFAULT_SIGN_PLAYER2;
        } else if (option == JOptionPane.NO_OPTION) {
            String player1 = StartGame.showDelayedInputDialog("Enter Player 1 sign (e.g., X):");
            if (player1 != null && !player1.isEmpty()) {
                game.player1Sign = player1;
            }

            String player2 = StartGame.showDelayedInputDialog("Enter Player 2 sign (e.g., O):");
            if (player2 != null && !player2.isEmpty()) {
                game.player2Sign = player2;
            }
        }
    }
}
