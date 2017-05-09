package 反射机制;
//获取某个特定的方法，通过反射机制执行
//以前：
//		CustomerService cs=new CustomerService();
//		boolean isSucess=cs.login("sdmin","132");
//
import java.lang.reflect.*;
public class Test06 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//获取类
		Class c=Class.forName("反射机制.Employee");
		//获取某个特定方法
		//通过：方法名+形参
		Method m=c.getDeclaredMethod("login",String.class,String.class);
		// Method getDeclaredMethod(String name, Class<?>... parameterTypes) 
        //返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法。
		
		//通过反射机制执行login方法
		Object o=c.newInstance();
		
		//通过o对象的m方法，传递“admin”,"123"参数，方法的执行结果是
		// Object invoke(Object obj, Object... args) 
		Object retValue=m.invoke(o, "admin","123");
        //对带有指定参数的指定对象调用由此 Method 对象表示的底层方法 
		
		System.out.println(retValue);
	}
}
