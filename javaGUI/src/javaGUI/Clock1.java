package javaGUI;
import java.applet.*;
import java.util.Date;
import java.awt.*;
public class Clock1 extends Applet {
	public void paint(Graphics g){
		Date timeNow=new Date();
		String strTime=timeNow.getHours()+":"+timeNow.getMinutes()+":"+timeNow.getSeconds();
		g.drawString(strTime, 100, 20);
	}
}
