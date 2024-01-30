import java.awt.Graphics;
import java.applet.Applet;
public class applet extends Applet
{
    public void paint(Graphics g)
    {
     g.drawString("This is my first Applets Program", 150, 150);
    }
}

/*
<applet code="applet.class" width="300" height="300">
</applet>
 */