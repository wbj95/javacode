package �������;
//��ȡĳ���ض��ķ�����ͨ���������ִ��
//��ǰ��
//		CustomerService cs=new CustomerService();
//		boolean isSucess=cs.login("sdmin","132");
//
import java.lang.reflect.*;
public class Test06 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//��ȡ��
		Class c=Class.forName("�������.Employee");
		//��ȡĳ���ض�����
		//ͨ����������+�β�
		Method m=c.getDeclaredMethod("login",String.class,String.class);
		// Method getDeclaredMethod(String name, Class<?>... parameterTypes) 
        //����һ�� Method ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ��������������
		
		//ͨ���������ִ��login����
		Object o=c.newInstance();
		
		//ͨ��o�����m���������ݡ�admin��,"123"������������ִ�н����
		// Object invoke(Object obj, Object... args) 
		Object retValue=m.invoke(o, "admin","123");
        //�Դ���ָ��������ָ����������ɴ� Method �����ʾ�ĵײ㷽�� 
		
		System.out.println(retValue);
	}
}
