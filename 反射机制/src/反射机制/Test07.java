package �������;
//��ȡ����ͽӿ�
public class Test07 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//��ȡ��
		//Class c=Class.forName("java.lang.String");
		Class c=Class.forName("java.util.Date");
		
		//��ȡ����,Class<? super T> getSuperclass() 
        //���ر�ʾ�� Class ����ʾ��ʵ�壨�ࡢ�ӿڡ��������ͻ� void���ĳ���� Class�� 
		Class superClass=c.getSuperclass();
		
		System.out.println(superClass.getName());
		
		//��ȡ�ӿڣ� Class<?>[] getInterfaces() 
        //ȷ���˶�������ʾ�����ӿ�ʵ�ֵĽӿڡ�
		Class[] Ins=c.getInterfaces();	
		for(Class css:Ins)
		{
			System.out.println(css.getName());
		}
	}
}
