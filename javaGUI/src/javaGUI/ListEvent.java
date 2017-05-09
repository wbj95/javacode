package javaGUI;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class ListEvent extends Applet implements ItemListener{
	List ll=new List(3);
	Label l1=new Label("城市区号"),
		l2=new Label("城市名称"),
		l3=new Label("    ");
	String name[]={"桐岭","武宣","来宾","柳州"},
			code[]={"001","002","003","004"};
	public void init(){
		setLayout(new FlowLayout());
		for(int i=0;i<code.length;i++){
			ll.add(code[i]);
		}
		add(l1);
		add(ll);
		add(l2);
		add(l3);
		ll.addItemListener(this);
		
	}
	public void itemStateChanged(ItemEvent e){
		int c;
		Integer ii=(Integer)e.getItem();
		c=ii.intValue();
		l3.setText(name[c]);
	}
}
