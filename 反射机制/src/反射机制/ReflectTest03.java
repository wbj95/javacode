package 反射机制;
import java.text.SimpleDateFormat;
//获取Class类型对象之后，就可以创建该类对象
import java.util.Date;
public class ReflectTest03 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
	Class c=	Class.forName("反射机制.Employee");
	
	Object o=c.newInstance();//创建此 Class 对象所表示的类的一个新实例。调用了Employee的无参数构造方法
	
	System.out.println(o);//自动调用O的toString方法。反射机制.Employee@2a139a55
	
	Class c1=Class.forName("java.util.Date");
	Object o1=c1.newInstance();
	
	if(o1 instanceof Date)
	{
		Date t=(Date)o1;
		//2016-05-14 15:24;00 301
		//获取系统当前时间
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm;ss SSS").format(t));
	}
	}
}
