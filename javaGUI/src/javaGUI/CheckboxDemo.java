package javaGUI;
import java.applet.*;
import java.awt.*;
public class CheckboxDemo extends Applet{
	public void init(){
		String []str={"瘪陶屎","阿胆屌","帅哥韦","老板张","猪心覃","丰胸林"};
		Checkbox c[]=new Checkbox[6];
		CheckboxGroup cg=new CheckboxGroup();
		add(new Label("下列哪个人最帅："));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i],false,cg);
			add(c[i]);
		}
		add(new Label("下列哪个人屌短小精悍："));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i]);
			add(c[i]);
		}
		add(new Label("下列哪些是有钱人有钱："));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i]);
			add(c[i]);
		}
		add(new Label("下列个胸最大："));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i],false,cg);
			add(c[i]);
		}
	}
}
