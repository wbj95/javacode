package �������;

import java.sql.Date;

/*
 * �ȿ�һ�·���ĸ��
              ��Ҫ��ָ������Է��ʣ������޸�������״̬����Ϊ��һ�����������ܸ���������Ϊ��״̬�ͽ�����������޸�Ӧ����������Ϊ��״̬����ص����塣
             ������java��һ��ǿ��Ĺ��ߣ��ܹ�ʹ���Ǻܷ���Ĵ������Ĵ��룬��Щ�������������ʱװ�䣬���������֮�����Դ�������ӡ����Ƿ���ʹ�ò�����ɱ��ܸߣ�
 * 
 * ������SUM�ṩ�ķ�������е���
 * 
 * java.lang.Class;                      Class c=0x123456;
 * java.lang.reflect.Constructor;		 Constructor o=0x12345;
 * java.lang.reflect.Field;				 Filed f=0x12345;  ����
 * java.lang.reflect.Method;			 Method m=0x123456;
 * java.lang.reflect.Modifier;			 Modifier m=0x456;  ���η�
 * 
 * ������Ƶ����ã�
 * 			1�������룺.class-->.java
 * 			2, ͨ��������Ʒ���java������ԣ����������췽����
 * 
 * 
 * ��ȡClass���������ַ�ʽ
 * 
 * 
 * 
 */


import java.lang.*;

public class ReflectTest01 {

	public static  void main(String[] args)  {
		// TODO Auto-generated method stub

		//��һ�ַ�ʽ
		try {
			Class c=Class.forName("�������.Employee");
			Class cc = c.getSuperclass();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//c���ñ����ڴ��ַָ����еĶ��󣬸ö��������Employee������
		
		//�ڶ��ַ�ʽ
		//java��ÿ���඼��Class����
		Class c1=Employee.class;
		
		
		
		//�����ַ�ʽ
		//java�������κ�һ��java������getClass����
		Employee e=new Employee();
		Class c2=e.getClass();//c2������ʱ�ࣨe������ʱ����employee��
		
		//System.out.println(c=c1);
		System.out.println(c2==c1);//true
		
		
		Class c3=Date.class;
		try {
			Class c4=Class.forName("java.lang.Integer");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//����д��ȫ������������
		
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