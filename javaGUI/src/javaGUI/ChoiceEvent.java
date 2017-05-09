package javaGUI;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class ChoiceEvent extends Applet implements ItemListener{
	Choice cc=new Choice();
	Label l1=new Label("城市区号"),
		  l2=new Label("城市名称"),
		  l3=new Label("        ");
	String code[]={"001","002","003","004"},
	        name[]={"北京","柳州","上海","武宣"};
	public void init(){
		setLayout(new FlowLayout());
		for(int i=0;i<code.length;i++){
			cc.add(code[i]);
		}
		add(l1);
		add(cc);
		add(l2);
		add(l3);
		cc.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e){
		int c=0;
		String str=(String)e.getItem();
		System.out.println(e.getItem());
		for(int j=0;j<code.length;j++)
			if(str==code[j]){
				c=j;
				break;
			}
		l3.setText(name[c]);
	}
}
