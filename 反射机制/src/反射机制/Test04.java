package �������;

import java.lang.reflect.Field;

//��ȡĳ���ض�������
public class Test04 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
	/*
	 * ��ǰ��ʽ��
	 * Employee e=new Employee();
	 * e.name="zhangsan";set
	 * system.out.print(e.name);//get
	 */
		
		//��ȡ��
		Class c=Class.forName("�������.Employee");
		
		//��ȡ������
		Field f=c.getDeclaredField("name");
		Field ff=c.getDeclaredField("no");
		//��ȡĳ���ض����Կ���������set,get
		Object o=c.newInstance();
		Object o1=c.newInstance();
		//���Ʒ�װ
		f.setAccessible(true);
		ff.setAccessible(true);
		//ʹ�÷�����ƿ��Դ��Ʒ�װ�ԣ�ʹ��java��������Բ���ȫ
		
		
		//��o����name���Ը�ֵ��zhangsan��
		//void set(Object obj, Object value) 
        //��ָ����������ϴ� Field �����ʾ���ֶ�����Ϊָ������ֵ�� 
		f.set(o, "zhangsan");
		ff.set(o1,110);
		
		//get
		// Object get(Object obj) 
        //����ָ�������ϴ� Field ��ʾ���ֶε�ֵ�� 
		System.out.println(f.get(o));
		System.out.println(ff.get(o1));
	}

}
