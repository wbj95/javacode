package javaGUI;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class AppletButtonEvent extends Applet implements ActionListener{
   TextField input1, input,output;
   public void init(){
	   Label prompt =new Label("请输入用户名");
	   Label L1=new Label("请输入密码");
	   Button btn=new Button("OK");
	   input =new TextField(8);
	   input1 =new TextField(6);
	   output =new TextField(20);
	   output.setEditable(false);
	   add(prompt);
	   add(input);
	   add(L1);
	   add(input1);
	   add(btn);
	   add(output);
	   btn.addActionListener(this);
	   
   }
   public void actionPerformed(ActionEvent e){
	   output.setText(input.getText()+",Welcome");
   }
}
