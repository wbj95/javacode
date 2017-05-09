package javaGUI;
import java.awt.*;
import java.applet.*;
public class ButtonDemo extends Applet{
	public void init(){
		Label one=new Label("     ±ÒÃ’       ");
		Label two=new Label();
		two.setText("     ∞¢µ®        ");
		Button btn1=new Button("¥ÚÀ¿±ÒÃ’");
		Button btn2=new Button();
		btn2.setLabel("¡Ïµº∞¢µ®");
		add(one);
		add(two);
		add(btn1);
		add(btn2);
	}
}
