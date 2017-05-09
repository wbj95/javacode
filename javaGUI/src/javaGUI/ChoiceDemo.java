package javaGUI;
//显示包含3个选项的Choice列表框的程序，
import java.applet.*;
import java.awt.*;
public class ChoiceDemo extends Applet{
	public void init(){
		Choice testChoice=new Choice();
		testChoice.addItem("瘪陶");
		testChoice.addItem("阿胆屌");
		testChoice.addItem("老板张");
		add(testChoice);
	}
}
