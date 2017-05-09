import java.awt.*;
import java.applet.Applet;
public class HelloApplet extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString("Hello!",20,20);
	}
}