package �������;

import java.text.Format.Field;
import java.lang.reflect.*;
public class Test03 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//��ȡ�����
		//Class c=Class.forName("�������.Employee");
		//Class c=Class.forName("java.lang.String");
		//Class c=Class.forName("java.lang.Integer");
		Class c=Class.forName("java.lang.Class");
		
		
		//Field   getField(String name)  ����һ�� Field ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա�ֶΡ�
		//getFields()  ����һ������ĳЩ Field ��������飬��Щ����ӳ�� Class ��������ʾ�����ӿڵ����пɷ��ʹ����ֶΡ�
		
		//��ȡField����
		/*java.lang.reflect.Field[] f=c.getFields();
		System.out.println(f.length);
		System.out.println(f[0].getName());*/
		
		//getDeclaredField(String name)����һ�� Field ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ���������ֶΡ�
		//getDeclaredFields()���� Field �����һ�����飬��Щ����ӳ�� Class ��������ʾ�����ӿ��������������ֶΡ�
		java.lang.reflect.Field[] f=c.getDeclaredFields();
		
		/*for(int i=0;i<f.length;i++){
			//���η�
			int iii=f[i].getModifiers();//��������ʽ�����ɴ� Field �����ʾ���ֶε� Java �������η���
            //System.out.println(iii);
            String str=Modifier.toString(iii);//static String toString(int mod)             ��������ָ�����η��еķ������η���־���ַ����� 
			System.out.println(str);
			
			//����
			Class type=f[i].getType();
			//System.out.println(type.getName());
			System.out.println(type.getSimpleName());
			
			
			System.out.println(f[i].getName());//���Ե�����
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
