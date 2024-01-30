import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField inputField;

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the input field
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(280, 40));
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setEditable(false);

        // Create buttons
        String[] buttonLabels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Add components to the content pane
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(inputField, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        String currentText = inputField.getText();

        if (action.equals("=")) {
            try {
                double result = evaluateExpression(currentText);
                inputField.setText(Double.toString(result));
            } catch (ArithmeticException ex) {
                inputField.setText("Error");
            }
        } else if (action.equals("C")) {
            inputField.setText("");
        } else {
            inputField.setText(currentText + action);
        }
    }

    private double evaluateExpression(String expression) {
        try {
            return new Object() {
                int index = -1, ch;

                void nextChar() {
                    ch = (++index < expression.length()) ? expression.charAt(index) : -1;
                }

                boolean isDigit() {
                    return Character.isDigit(ch);
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (index < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                    return x;
                }

                double parseExpression() {
                    double x = parseTerm();
                    while (true) {
                        if (eat('+')) x += parseTerm();
                        else if (eat('-')) x -= parseTerm();
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    while (true) {
                        if (eat('*')) x *= parseFactor();
                        else if (eat('/')) x /= parseFactor();
                        else return x;
                    }
                }

                double parseFactor() {
                    if (eat('+')) return parseFactor();
                    if (eat('-')) return -parseFactor();

                    double x;
                    int startPos = index;
                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else if (isDigit()) {
                        while (isDigit()) nextChar();
                        x = Double.parseDouble(expression.substring(startPos, index));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char)ch);
                    }

                    return x;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }
            }.parse();
        } catch (Exception e) {
            throw new ArithmeticException("Invalid expression");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorApp();
        });
    }
}
