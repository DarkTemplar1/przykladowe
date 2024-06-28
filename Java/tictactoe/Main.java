package projekt;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
public class Main {

    public static void main(String[] args) {
        AtomicInteger lineToWin = new AtomicInteger(Static.DEFAULT_LINE_TO_WIN);
        AtomicInteger boradSize = new AtomicInteger(Static.DEFAULT_BOARD_SIZE);

        SwingUtilities.invokeLater(() -> {
           // size = Integer.parseInt(JOptionPane.showInputDialog("Enter the board size:"));
            String size = JOptionPane.showInputDialog("Enter the board size:");
            try {
                boradSize.set(Integer.parseInt(size));
            } catch (NumberFormatException e) {
                boradSize.set(Static.DEFAULT_BOARD_SIZE); // Default value
            }
         //   int lineToWin = Integer.parseInt(JOptionPane.showInputDialog("Enter the length line to win:"));
            String lineToWinInput = JOptionPane.showInputDialog("Enter the number of signs required to win:");
            try {
                lineToWin.set(Integer.parseInt(lineToWinInput));
            } catch (NumberFormatException e) {
                lineToWin.set(Static.DEFAULT_LINE_TO_WIN); // Default value
            }
            //validacja
            if(lineToWin.get() < 3 ) lineToWin.set(Static.DEFAULT_LINE_TO_WIN);
            if(boradSize.get() < 3 ) boradSize.set(Static.DEFAULT_BOARD_SIZE);
            if (lineToWin.get() > boradSize.get()) {
                lineToWin.set(Static.DEFAULT_LINE_TO_WIN);
                boradSize.set(Static.DEFAULT_BOARD_SIZE);
            }

            TicTacToeGUI game = new TicTacToeGUI(boradSize.get(), lineToWin.get());
            StartGame.startGame(game);
        });
    }
}
