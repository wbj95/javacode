package 反射机制;

import java.text.Format.Field;
import java.lang.reflect.*;
public class Test03 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//获取这个类
		//Class c=Class.forName("反射机制.Employee");
		//Class c=Class.forName("java.lang.String");
		//Class c=Class.forName("java.lang.Integer");
		Class c=Class.forName("java.lang.Class");
		
		
		//Field   getField(String name)  返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。
		//getFields()  返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段。
		
		//获取Field属性
		/*java.lang.reflect.Field[] f=c.getFields();
		System.out.println(f.length);
		System.out.println(f[0].getName());*/
		
		//getDeclaredField(String name)返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。
		//getDeclaredFields()返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
		java.lang.reflect.Field[] f=c.getDeclaredFields();
		
		/*for(int i=0;i<f.length;i++){
			//修饰符
			int iii=f[i].getModifiers();//以整数形式返回由此 Field 对象表示的字段的 Java 语言修饰符。
            //System.out.println(iii);
            String str=Modifier.toString(iii);//static String toString(int mod)             返回描述指定修饰符中的访问修饰符标志的字符串。 
			System.out.println(str);
			
			//类型
			Class type=f[i].getType();
			//System.out.println(type.getName());
			System.out.println(type.getSimpleName());
			
			
			System.out.println(f[i].getName());//属性的名字
		}*/
		
		StringBuffer sb=new StringBuffer();
		
		sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+"{\n");
		
		for(int i = 0;i<f.length;i++)
		{
			sb.append("\t"+Modifier.toString(f[i].getModifiers())+" ");
			sb.append(f[i].getType().getSimpleName()+" ");
			sb.append(f[i].getName()+";\n");
		}
		sb.append("}");
		System.out.println(sb);
	}

}
