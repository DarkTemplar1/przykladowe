package projekt;

import javax.swing.*;
import java.awt.*;


public class TicTacToeGUI extends JFrame {
   final JButton[][] buttons;
    boolean xTurn;
    boolean againstBot;
    String player1Sign;
    String player2Sign;
    final int boardSize;
    final int lineToWin;
    Color winningLineColor;



    TicTacToeGUI(int size, int lineToWin) {
        super("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100 * size, 100 * size);
        setLayout(new GridLayout(size, size));

        buttons = new JButton[size][size];
        xTurn = true;
        againstBot = false;
        boardSize = size;
        this.lineToWin = lineToWin;

        player1Sign = Static.DEFAULT_SIGN_PLAYER1;
        player2Sign = Static.DEFAULT_SIGN_PLAYER2;

        prepareToStartGame(size);
    }

    private void prepareToStartGame(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                buttons[i][j].addActionListener(new ButtonListener(this));
                add(buttons[i][j]);
            }
        }
    }

}
