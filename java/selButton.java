import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class selButton extends Applet implements ItemListener {
    private Label selectedLabel;
    private CheckboxGroup checkboxGroup;

    public void init() {
        checkboxGroup = new CheckboxGroup();

        Checkbox radioBtn1 = new Checkbox("True", checkboxGroup, false);
        Checkbox radioBtn2 = new Checkbox("False", checkboxGroup, false);

        selectedLabel = new Label("Selected Button: ");

        add(radioBtn1);
        add(radioBtn2);
        add(selectedLabel);

        radioBtn1.addItemListener(this);
        radioBtn2.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof Checkbox) {
            Checkbox selectedButton = (Checkbox) e.getSource();
            selectedLabel.setText("Selected Button: " + selectedButton.getLabel());
        }
    }
    public static void main(String args[])
    {
        new selButton();
    }
}
/*  <applet code="selButton.class" width="300" height="400">  </applet>*/