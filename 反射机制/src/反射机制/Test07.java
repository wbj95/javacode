package 反射机制;
//获取父类和接口
public class Test07 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//获取类
		//Class c=Class.forName("java.lang.String");
		Class c=Class.forName("java.util.Date");
		
		//获取父类,Class<? super T> getSuperclass() 
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。 
		Class superClass=c.getSuperclass();
		
		System.out.println(superClass.getName());
		
		//获取接口， Class<?>[] getInterfaces() 
        //确定此对象所表示的类或接口实现的接口。
		Class[] Ins=c.getInterfaces();	
		for(Class css:Ins)
		{
			System.out.println(css.getName());
		}
	}
}
