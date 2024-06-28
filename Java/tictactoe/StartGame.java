package projekt;

import javax.swing.*;

public class StartGame {
    public static void startGame(TicTacToeGUI game) {

        int option = showDelayedOptionDialog("Select Game Mode", "Game Mode", new Object[]{"Player vs Player", "Player vs Bot", "Cancel"});
        if (option == JOptionPane.YES_OPTION) {
            game.againstBot = false;
            GetPlayerSigns.getPlayerSigns(game);
        } else if (option == JOptionPane.NO_OPTION) {
            game.againstBot = true;
        } else {
            System.exit(0);
        }

        int colorOption = showDelayedOptionDialog("Select Winning Line Color", "Winning Line Color", new Object[]{"Red", "Green", "Blue"});
        if (colorOption == JOptionPane.YES_OPTION) {
            game.winningLineColor = Static.COLOR_RED;
        } else if (colorOption == JOptionPane.NO_OPTION) {
            game.winningLineColor = Static.COLOR_GREEN;
        } else {
            game.winningLineColor = Static.COLOR_BLUE;
        }

        game.setVisible(true);
    }

    static int showDelayedOptionDialog(String message, String title, Object[] options) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    static String showDelayedInputDialog(String message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JOptionPane.showInputDialog(null, message);
    }
}
