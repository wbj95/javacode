package javaGUI;
import java.applet.*;
import java.awt.*;
public class CheckboxDemo extends Applet{
	public void init(){
		String []str={"����ʺ","������","˧��Τ","�ϰ���","������","������"};
		Checkbox c[]=new Checkbox[6];
		CheckboxGroup cg=new CheckboxGroup();
		add(new Label("�����ĸ�����˧��"));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i],false,cg);
			add(c[i]);
		}
		add(new Label("�����ĸ��ˌŶ�С������"));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i]);
			add(c[i]);
		}
		add(new Label("������Щ����Ǯ����Ǯ��"));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i]);
			add(c[i]);
		}
		add(new Label("���и������"));
		for(int i=0;i<6;i++){
			c[i]=new Checkbox(str[i],false,cg);
			add(c[i]);
		}
	}
}
