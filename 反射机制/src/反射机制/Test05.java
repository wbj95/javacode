package �������;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//java.lang.reflect.method;
public class Test05 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
			//��ȡ�࣬
	
			//Class c=Class.forName("�������.Employee");
			Class c=Class.forName("java.lang.String");
			//��ȡ���еķ���
			Method[] mt=c.getDeclaredMethods();
			
			/*for(Method m:mt){
				//���η�
				System.out.println(Modifier.toString(m.getModifiers()));
				
				//����ֵ���ͣ�Class<?> getReturnType() 
		          //����һ�� Class ���󣬸ö��������˴� Method ��������ʾ�ķ�������ʽ�������͡� 
				Class returntype=m.getReturnType();
				System.out.println(returntype.getSimpleName());
				//������
				System.out.println(m.getName());
				
				//�����б�, Class<?>[] getParameterTypes() 
		          //��������˳�򷵻� Class ��������飬��Щ���������˴� Method ��������ʾ�ķ������β����͡� 
				Class [] ParamaterTypes=m.getParameterTypes();
				for(Class ParamaterType:ParamaterTypes)
				{
					System.out.println(ParamaterType.getSimpleName());
				}
			}*/
			//������
			StringBuffer sb=new StringBuffer();
			
			sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+"{\n");
			
			for(int i=0;i<mt.length;i++)
			{
				sb.append("\t"+Modifier.toString(mt[i].getModifiers())+" ");
				sb.append(mt[i].getReturnType().getSimpleName()+" ");
				sb.append(mt[i].getName()+"(");
			//�β�
				Class [] ParamaterTypes=mt[i].getParameterTypes();
				for(int j=0;j<ParamaterTypes.length;j++)
				{
					if(j==ParamaterTypes.length-1)
					{
						sb.append(ParamaterTypes[j].getSimpleName());
					}else
					{
						sb.append(ParamaterTypes[j].getSimpleName()+",");
					}
					
				}
				
					
					sb.append("){}\n");
			}
			sb.append("}");
			System.out.println(sb);
			
	}

}
