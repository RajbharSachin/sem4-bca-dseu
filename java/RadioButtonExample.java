import java.awt.*;
import java.awt.event.*;

public class RadioButtonExample extends Frame {
    private Label resultLabel;

    public RadioButtonExample() {
        setTitle("Radio Button Example");
        setLayout(new GridLayout(0, 1));

        resultLabel = new Label("Selected Button: ");
        add(resultLabel);

        CheckboxGroup checkboxGroup = new CheckboxGroup();

        Checkbox radioBtn1 = new Checkbox("Option 1", checkboxGroup, false);
        radioBtn1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (radioBtn1.getState()) {
                    resultLabel.setText("Selected Button: " + radioBtn1.getLabel());
                }
            }
        });
        add(radioBtn1);

        Checkbox radioBtn2 = new Checkbox("Option 2", checkboxGroup, false);
        radioBtn2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (radioBtn2.getState()) {
                    resultLabel.setText("Selected Button: " + radioBtn2.getLabel());
                }
            }
        });
        add(radioBtn2);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new RadioButtonExample();
    }
}
