package �������;
import java.lang.*;
public class ReflectTest02 {



	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//��A.Class�ļ�װ�ص�java������Ĺ���
		try {
			Class.forName("�������.A");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//A123456
		
		 Class c=A.class;//����ִ�о�̬����
		
	}
		
	
}
class A{
	static{
		System.out.println("A123456");
	}
}