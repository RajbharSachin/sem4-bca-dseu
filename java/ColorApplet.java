import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ColorApplet extends Applet {
    public void init() {
        // Set the background color
        setBackground(Color.CYAN);

        // Set the foreground (text) color
        setForeground(Color.RED);
    }

    public void paint(Graphics g) {
        String message = "Welcome to Color Applet!";
        g.drawString(message, 20, 50);
    }
}