import java.applet.*;
import java.awt.*;


public class smileyvikas extends Applet {
    public void paint(Graphics g)
    {
 
        // Oval for face outline
        
        g.drawOval(80, 70, 150, 150);
 
        // Ovals for eyes
        // with black color filled
        g.setColor(Color.BLACK);
        g.fillOval(120, 120, 15, 15);
        g.fillOval(170, 120, 15, 15);

        int x[]=  {152,142,163,152};
        int y[]=  {150,169,169,150};
        g.drawPolygon(x, y, 4);
        g.drawLine (150,130,150,170);
    }
}

/*
<applet code ="smiley.class" width="600" height="600">
</applet>
*/