import java.applet.*;
import java.awt.*;
public class smiley extends Applet{
public void paint(Graphics g)
{
 g.drawOval(80, 70, 150, 150);
 g.setColor(Color.BLACK);
 g.drawLine(155,160,155,140);
 g.fillOval(120, 120, 15, 15);
 g.fillOval(170, 120, 15, 15);
 
 //g.drawArc(130, 180, 50, 20, 180, 180);
 g.fillArc(130,180,50,20,180,180);
 }
} /*<applet code="smiley.java" height=355 width=300></applet> */