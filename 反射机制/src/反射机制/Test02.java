package �������;
//�������+IO+properties

import java.io.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
			//�������Զ���
		Properties p=new Properties();
		//������
		FileInputStream ff=new FileInputStream("ClassInfo.txt");
		//����
		p.load(ff);
		//�ر���
		ff.close();
		//ͨ��key��ȡvalue
		String ss=p.getProperty("classname");
		String ss1=p.getProperty("classname1");
	//System.out.println(ss);
		//ͨ��������ƴ�������
		Class c=Class.forName(ss);
		Class c1=Class.forName(ss1);
		
		Object o=c.newInstance();
		Object o1=c.newInstance();
		System.out.println(o);
		System.out.println(o1);

	}

}
