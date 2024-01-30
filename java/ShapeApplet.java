import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ShapeApplet extends Applet {
    public void paint(Graphics g) {
        // Draw a rectangle
        g.setColor(Color.RED);
        g.fillRect(20, 20, 100, 50);

        // Draw an oval
        g.setColor(Color.GREEN);
        g.fillOval(150, 20, 100, 100);

        // Draw a triangle
        g.setColor(Color.BLUE);
        int[] xPoints = {250, 350, 300};
        int[] yPoints = {200, 200, 100};
        g.fillPolygon(xPoints, yPoints, 3);

        // Draw a circle
        g.setColor(Color.YELLOW);
        g.fillOval(100, 150, 100, 100);
    }
}