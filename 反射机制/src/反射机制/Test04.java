package 反射机制;

import java.lang.reflect.Field;

//获取某个特定的属性
public class Test04 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
	/*
	 * 以前方式：
	 * Employee e=new Employee();
	 * e.name="zhangsan";set
	 * system.out.print(e.name);//get
	 */
		
		//获取类
		Class c=Class.forName("反射机制.Employee");
		
		//获取属性名
		Field f=c.getDeclaredField("name");
		Field ff=c.getDeclaredField("no");
		//获取某个特定属性可以用来？set,get
		Object o=c.newInstance();
		Object o1=c.newInstance();
		//打破封装
		f.setAccessible(true);
		ff.setAccessible(true);
		//使用反射机制可以打破封装性，使得java对象的属性不安全
		
		
		//给o对象name属性赋值“zhangsan”
		//void set(Object obj, Object value) 
        //将指定对象变量上此 Field 对象表示的字段设置为指定的新值。 
		f.set(o, "zhangsan");
		ff.set(o1,110);
		
		//get
		// Object get(Object obj) 
        //返回指定对象上此 Field 表示的字段的值。 
		System.out.println(f.get(o));
		System.out.println(ff.get(o1));
	}

}
