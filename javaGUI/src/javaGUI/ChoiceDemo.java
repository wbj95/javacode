package javaGUI;
//��ʾ����3��ѡ���Choice�б��ĳ���
import java.applet.*;
import java.awt.*;
public class ChoiceDemo extends Applet{
	public void init(){
		Choice testChoice=new Choice();
		testChoice.addItem("����");
		testChoice.addItem("������");
		testChoice.addItem("�ϰ���");
		add(testChoice);
	}
}
