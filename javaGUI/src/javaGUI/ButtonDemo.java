package javaGUI;
import java.awt.*;
import java.applet.*;
public class ButtonDemo extends Applet{
	public void init(){
		Label one=new Label("     ����       ");
		Label two=new Label();
		two.setText("     ����        ");
		Button btn1=new Button("��������");
		Button btn2=new Button();
		btn2.setLabel("�쵼����");
		add(one);
		add(two);
		add(btn1);
		add(btn2);
	}
}
