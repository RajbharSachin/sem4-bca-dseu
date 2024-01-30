import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleGame extends JFrame implements ActionListener {

    private JPanel panel;
    private List<JButton> puzzlePieces;
    private JButton resetButton;
    private int emptyIndex;
    private JButton emptyPiece;

    public PuzzleGame() {
        setTitle("Puzzle Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(4, 4));
        puzzlePieces = new ArrayList<>();

        // Create puzzle pieces
        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            puzzlePieces.add(button);

        }
        // Create empty piece
        emptyPiece = new JButton("");
        emptyPiece.setEnabled(false);
        puzzlePieces.add(emptyPiece);
        // Shuffle the puzzle pieces
        Collections.shuffle(puzzlePieces);

        // Add puzzle pieces to the panel
        for (JButton piece : puzzlePieces) {
            panel.add(piece);
        }

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        // Add components to the frame
        add(panel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == resetButton) {
            // Reset the puzzle by shuffling the pieces
            Collections.shuffle(puzzlePieces);
        } else {
            int sourceIndex = puzzlePieces.indexOf(source);
            if (isAdjacent(sourceIndex, emptyIndex)) {
                // Swap the puzzle piece with the empty piece
                Collections.swap(puzzlePieces, sourceIndex, emptyIndex);
            }
        }

        // Update the panel with the new arrangement of pieces
        panel.removeAll();
        for (JButton piece : puzzlePieces) {
            panel.add(piece);
        }
        panel.revalidate();
        panel.repaint();
        // Update the index of the empty piece
        emptyIndex = puzzlePieces.indexOf(emptyPiece);
    }

    private boolean isAdjacent(int index1, int index2) {
        int row1 = index1 / 4;
        int col1 = index1 % 4;
        int row2 = index2 / 4;
        int col2 = index2 % 4;

        return (Math.abs(row1 - row2) == 1 && col1 == col2) || (Math.abs(col1 - col2) == 1 && row1 == row2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PuzzleGame game = new PuzzleGame();
                game.setVisible(true);
            }
        });
    }
}
