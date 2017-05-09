package 反射机制;
//反射机制+IO+properties

import java.io.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
			//创建属性对象
		Properties p=new Properties();
		//创建流
		FileInputStream ff=new FileInputStream("ClassInfo.txt");
		//加载
		p.load(ff);
		//关闭流
		ff.close();
		//通过key获取value
		String ss=p.getProperty("classname");
		String ss1=p.getProperty("classname1");
	//System.out.println(ss);
		//通过反射机制创建对象
		Class c=Class.forName(ss);
		Class c1=Class.forName(ss1);
		
		Object o=c.newInstance();
		Object o1=c.newInstance();
		System.out.println(o);
		System.out.println(o1);

	}

}
