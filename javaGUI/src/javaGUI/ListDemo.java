package javaGUI;
//List�б��
import java.applet.*;
import java.awt.*;
public class ListDemo extends Applet{
	public void init(){
		String [] name={"����ʺ","������","�ϰ���","˧��Τ","������","������"};
		List list=new List(4,true);
		for(int j=0;j<name.length;j++){
			list.add(name[j]);
			}
		add(list);
	}
}
