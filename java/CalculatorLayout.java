import java.awt.*;
import java.awt.event.*;

public class CalculatorLayout extends Frame {
    private TextField display;

    public CalculatorLayout() {
        setTitle("Calculator");
        setLayout(new GridLayout(2, 1));

        display = new TextField();
        display.setEditable(false);
        add(display);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "Reset"
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String buttonText = ((Button) e.getSource()).getLabel();

            if (buttonText.equals("=")) {
                String expression = display.getText();

                Object result = evaluateExpression(expression);
                if (result != null) {
                    display.setText(result.toString());
                } else {
                    display.setText("Error");
                }
            } else if (buttonText.equals("Reset")) {
                display.setText("");
            } else if (buttonText.equals("<-")) {
                String currentText = display.getText();
                if (!currentText.isEmpty()) {
                    String updatedText = currentText.substring(0, currentText.length() - 1);
                    display.setText(updatedText);
                }
            } else {
                display.setText(display.getText() + buttonText);
            }
        }
    }

    private Object evaluateExpression(String expression) {
        try {
            double result = 0;
            char operator = ' ';
            boolean isOperatorSet = false;
            String currentNumber = "";

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (Character.isDigit(ch) || ch == '.') {
                    currentNumber += ch;
                } else {
                    double number = Double.parseDouble(currentNumber);
                    currentNumber = "";

                    if (!isOperatorSet) {
                        result = number;
                        operator = ch;
                        isOperatorSet = true;
                    } else {
                        switch (operator) {
                            case '+':
                                result += number;
                                break;
                            case '-':
                                result -= number;
                                break;
                            case '*':
                                result *= number;
                                break;
                            case '/':
                                result /= number;
                                break;
                        }
                        operator = ch;
                    }
                }
            }

            if (!currentNumber.isEmpty()) {
                double number = Double.parseDouble(currentNumber);

                switch (operator) {
                    case '+':
                        result += number;
                        break;
                    case '-':
                        result -= number;
                        break;
                    case '*':
                        result *= number;
                        break;
                    case '/':
                        result /= number;
                        break;
                }
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new CalculatorLayout();
    }
}
