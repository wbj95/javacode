package java���;
/*
 * ��java.lang.Integer;����Ϊ���������������
 */

public class IntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡint���͵����ֵ����Сֵ
		System.out.println("���ֵ��"+Integer.MAX_VALUE);//���ֵ��2147483647
		System.out.println("��Сֵ��"+Integer.MIN_VALUE);//��Сֵ��-2147483648
		//��int��byte
		System.out.println("���ֵ��"+Byte.MAX_VALUE);//���ֵ��127
		System.out.println("��Сֵ��"+Byte.MIN_VALUE);//���ֵ��127
		//����Integer���͵Ķ���
		Integer a=new Integer("123");//String-->Integer
		Integer b=new Integer(124);//int-->Integer;
		
		//Integer c=new Integer("abc");//������ͨ�����������е�ʱ��ᱨ�쳣  ���ָ�ʽ���쳣
		//NumberFormatException
		System.out.println(a);
		System.out.println(b);
		//int-->Integer;
		Integer s=new Integer(156);
		Integer d=Integer.valueOf(10);
		//Integer-->int
		int i2=b.intValue();
		System.out.println(i2+1);
		//String-->int
		int age=Integer.parseInt("123");//����Ҫ������
		System.out.println(age+1);
		//String-->Integer
		Integer q=Integer.valueOf("123");
		//String-->double
		Double age1=Double.parseDouble("3.0");
		System.out.println(age1+2.0);
		//int-->������
		String i3=Integer.toBinaryString(10);
		System.out.println(i3);
		//int-->ʮ������
		String i4=Integer.toHexString(10);
		System.out.println(i4);
		//int-->�˽���
		String i5=Integer.toOctalString(10);
		System.out.println(i5);
	}

}
