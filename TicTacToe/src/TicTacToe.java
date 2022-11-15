import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random rdn = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50 , 50));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O's Turn");
                        checkWin();
                    }
                } else {
                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X's Turn");
                        checkWin();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(rdn.nextInt(2) == 0) {
            player1Turn = true;
            textField.setText("X's Turn");
        } else {
            player1Turn = false;
            textField.setText("O's Turn");
        }
    }

    public void checkWin() {
        //Check X Win Conditions
        if((Objects.equals(buttons[0].getText(), "X")) &&
           (Objects.equals(buttons[1].getText(), "X")) &&
           (Objects.equals(buttons[2].getText(), "X"))) {
            xWins(0, 1, 2);
        }
        if((Objects.equals(buttons[3].getText(), "X")) &&
           (Objects.equals(buttons[4].getText(), "X")) &&
           (Objects.equals(buttons[5].getText(), "X"))) {
            xWins(3, 4, 5);
        }
        if((Objects.equals(buttons[6].getText(), "X")) &&
           (Objects.equals(buttons[7].getText(), "X")) &&
           (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(6, 7, 8);
        }
        if((Objects.equals(buttons[0].getText(), "X")) &&
           (Objects.equals(buttons[3].getText(), "X")) &&
           (Objects.equals(buttons[6].getText(), "X"))) {
            xWins(0, 3, 6);
        }
        if((Objects.equals(buttons[1].getText(), "X")) &&
           (Objects.equals(buttons[4].getText(), "X")) &&
           (Objects.equals(buttons[7].getText(), "X"))) {
            xWins(1, 4, 7);
        }
        if((Objects.equals(buttons[2].getText(), "X")) &&
           (Objects.equals(buttons[5].getText(), "X")) &&
           (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(2, 5, 8);
        }
        if((Objects.equals(buttons[0].getText(), "X")) &&
           (Objects.equals(buttons[4].getText(), "X")) &&
           (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(0, 4, 8);
        }
        if((Objects.equals(buttons[2].getText(), "X")) &&
           (Objects.equals(buttons[4].getText(), "X")) &&
           (Objects.equals(buttons[6].getText(), "X"))) {
            xWins(2, 4, 6);
        }
        
        //Check O Win Conditions
        if((Objects.equals(buttons[0].getText(), "O")) &&
           (Objects.equals(buttons[1].getText(), "O")) &&
           (Objects.equals(buttons[2].getText(), "O"))) {
            oWins(0, 1, 2);
        }
        if((Objects.equals(buttons[3].getText(), "O")) &&
           (Objects.equals(buttons[4].getText(), "O")) &&
           (Objects.equals(buttons[5].getText(), "O"))) {
            oWins(3, 4, 5);
        }
        if((Objects.equals(buttons[6].getText(), "O")) &&
           (Objects.equals(buttons[7].getText(), "O")) &&
           (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(6, 7, 8);
        }
        if((Objects.equals(buttons[0].getText(), "O")) &&
           (Objects.equals(buttons[3].getText(), "O")) &&
           (Objects.equals(buttons[6].getText(), "O"))) {
            oWins(0, 3, 6);
        }
        if((Objects.equals(buttons[1].getText(), "O")) &&
           (Objects.equals(buttons[4].getText(), "O")) &&
           (Objects.equals(buttons[7].getText(), "O"))) {
            oWins(1, 4, 7);
        }
        if((Objects.equals(buttons[2].getText(), "O")) &&
           (Objects.equals(buttons[5].getText(), "O")) &&
           (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(2, 5, 8);
        }
        if((Objects.equals(buttons[0].getText(), "O")) &&
           (Objects.equals(buttons[4].getText(), "O")) &&
           (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(0, 4, 8);
        }
        if((Objects.equals(buttons[2].getText(), "O")) &&
           (Objects.equals(buttons[4].getText(), "O")) &&
           (Objects.equals(buttons[6].getText(), "O"))) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        textField.setText("X WINS!!");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        textField.setText("O WINS!!");
    }
}
