import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {

    private JButton[] buttons;
    private boolean isXTurn;
    private JLabel turnLabel;

    public TicTacToe() {
        super("Tic Tac Toe");

        buttons = new JButton[9];
        isXTurn = true;

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            boardPanel.add(buttons[i]);
        }

        turnLabel = new JLabel("X's Turn", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(boardPanel, BorderLayout.CENTER);
        add(turnLabel, BorderLayout.NORTH);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (isXTurn) {
            clickedButton.setText("X");
            turnLabel.setText("O's Turn");
        } else {
            clickedButton.setText("O");
            turnLabel.setText("X's Turn");
        }

        clickedButton.setEnabled(false);
        isXTurn = !isXTurn;

        checkForWin();
    }

    private void checkForWin() {
        String[] board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = buttons[i].getText();
        }

        if (checkRows(board) || checkColumns(board) || checkDiagonals(board)) {
            disableButtons();
            String winner = isXTurn ? "O" : "X";
            JOptionPane.showMessageDialog(this, winner + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else if (isBoardFull(board)) {
            disableButtons();
            JOptionPane.showMessageDialog(this, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean checkRows(String[] board) {
        for (int i = 0; i < 3; i++) {
            if (!board[i].isEmpty() && board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(String[] board) {
        for (int i = 0; i < 9; i += 3) {
            if (!board[i].isEmpty() && board[i].equals(board[i + 1]) && board[i].equals(board[i + 2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(String[] board) {
        if (!board[0].isEmpty() && board[0].equals(board[4]) && board[0].equals(board[8])) {
            return true;
        }
        if (!board[2].isEmpty() && board[2].equals(board[4]) && board[2].equals(board[6])) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull(String[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void disableButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }
}


