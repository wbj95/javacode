package 反射机制;

import java.sql.Date;

/*
 * 先看一下反射的概念：
              主要是指程序可以访问，检测和修改它本身状态或行为的一种能力，并能根据自身行为的状态和结果，调整或修改应用所描述行为的状态和相关的语义。
             反射是java中一种强大的工具，能够使我们很方便的创建灵活的代码，这些代码可以再运行时装配，无需在组件之间进行源代码链接。但是反射使用不当会成本很高！
 * 
 * 以下是SUM提供的反射机制中的类
 * 
 * java.lang.Class;                      Class c=0x123456;
 * java.lang.reflect.Constructor;		 Constructor o=0x12345;
 * java.lang.reflect.Field;				 Filed f=0x12345;  属性
 * java.lang.reflect.Method;			 Method m=0x123456;
 * java.lang.reflect.Modifier;			 Modifier m=0x456;  修饰符
 * 
 * 反射机制的作用：
 * 			1，反编译：.class-->.java
 * 			2, 通过反射机制访问java类的属性，方法，构造方法等
 * 
 * 
 * 获取Class类对象的三种方式
 * 
 * 
 * 
 */


import java.lang.*;

public class ReflectTest01 {

	public static  void main(String[] args)  {
		// TODO Auto-generated method stub

		//第一种方式
		try {
			Class c=Class.forName("反射机制.Employee");
			Class cc = c.getSuperclass();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//c引用保存内存地址指向堆中的对象，该对象代表是Employee整个类
		
		//第二种方式
		//java中每个类都有Class属性
		Class c1=Employee.class;
		
		
		
		//第三种方式
		//java语言中任何一个java对象都有getClass方法
		Employee e=new Employee();
		Class c2=e.getClass();//c2是运行时类（e的运行时类是employee）
		
		//System.out.println(c=c1);
		System.out.println(c2==c1);//true
		
		
		Class c3=Date.class;
		try {
			Class c4=Class.forName("java.lang.Integer");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//必须写类全名，还带包名
		
		Date d=new Date(0);
		Class c5=d.getClass();
		
		System.out.println(c5==c3);//true
	}

}
/*class Employee {
	//Filed
	String name;
	
	//Constructor
	Employee (){}
	
	Employee (String name){this.name=name;}
	
	//Method
	public void get(){
		System.out.println("  132456");
	}
}
*/