package 反射机制;
import java.lang.*;
public class ReflectTest02 {



	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//将A.Class文件装载到java虚拟机的过程
		try {
			Class.forName("反射机制.A");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//A123456
		
		 Class c=A.class;//不会执行静态语句块
		
	}
		
	
}
class A{
	static{
		System.out.println("A123456");
	}
}