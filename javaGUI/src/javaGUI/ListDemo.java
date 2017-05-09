package javaGUI;
//List列表框
import java.applet.*;
import java.awt.*;
public class ListDemo extends Applet{
	public void init(){
		String [] name={"瘪陶屎","阿胆屌","老板张","帅哥韦","猪心覃","军国梁"};
		List list=new List(4,true);
		for(int j=0;j<name.length;j++){
			list.add(name[j]);
			}
		add(list);
	}
}
