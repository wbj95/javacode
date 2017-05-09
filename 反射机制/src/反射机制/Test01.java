package 反射机制;

import java.io.*;
import java.util.*;

//IO+properties

//dbinfo这样的文件我们称为配置文件
//配置文件的作用是：是程序更灵活
//注意：一般在程序中可变的东西不要写死，推荐写到配置文件中，运行同样的文件得到不同的结果

//像dbinfo这样一个具有特殊内容的配置文件我们叫做：属性文件。
//java规范中要求属性文件以“properties”,不是必须的，只是建议

//属性文件中数据要求：
//key和value之间可以使用“空格”，“冒号”，“等号”。
//如果“空格”，“冒号”，“等号”都有，则按照最前的作为分隔符

public class Test01 {
	public static void main(String[] args) throws IOException{
		//1,创建属性对象
		Properties p=new Properties();//和Map一样，只不过key和value只能存储字符串类型
		//key不能重复。如果重复则value覆盖
		
		
		//创建输入流
		//FileInputStream f=new FileInputStream("D:/javachengxu/123.txt");
		FileInputStream f=new FileInputStream("dbinfo.txt");
		
		//将f流中的所有数据加载到属性对象中
		//所以现在属性对象中有（key=sdjfhshf,value=adfdg)
		try {
			p.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭流
		f.close();
		
		//通过key获取value
		String s1 =p.getProperty("driver");
		String s2 =p.getProperty("url");
		String s3 =p.getProperty("username");
		String s4 =p.getProperty("password");
		
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
	}
}
