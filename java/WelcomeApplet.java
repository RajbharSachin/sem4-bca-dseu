import java.applet.Applet;
import java.awt.Graphics;

public class WelcomeApplet extends Applet {
    public void paint(Graphics g) {
        String message = "Welcome to Applet. It is my first Applet program";
        g.drawString(message, 20, 20);
    }
}