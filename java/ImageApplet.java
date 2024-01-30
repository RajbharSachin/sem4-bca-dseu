import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class ImageApplet extends Applet {
    private Image image;

    public void init() {
        // Get the URL of the image file
        URL imageURL = getClass().getResource("image.jpg");

        // Load the image
        image = getImage(imageURL);
    }

    public void paint(Graphics g) {
        // Draw the image on the applet
        g.drawImage(image, 0, 0, this);
    }
}
/*
<applet code ="ImageApplet.class" width="600" height="600">
</applet>
*/
