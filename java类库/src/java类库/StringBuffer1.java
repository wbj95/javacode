package java���;

public class StringBuffer1 {
	/*
	 * StringBuffer�ഴ���ɱ䳤�Ϳ��޸ĵ��ַ�������Ҳ��Ϊ�ַ���������
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1=new StringBuffer();//�ַ���Ϊ0������Ϊ16
		int sb11=sb1.capacity();
		System.out.println(sb11);
		StringBuffer sb2=new StringBuffer(80);//�ַ�������Ϊ0������Ϊ80
		StringBuffer sb3=new StringBuffer("abcd");//�ַ���Ϊ��abcd��������Ϊ20
		StringBuffer sb4=new StringBuffer("abcdeabcd");
		int sb5=sb4.length();//��ȡ�ַ�������
		System.out.println(sb5);//9
		int sb6=sb4.capacity();//��ȡ�ַ���������������16+9
		System.out.println(sb6);//25
		char ch=sb4.charAt(3);//��ȡ�±�indexλ�õ��ַ�
		System.out.println(ch);//d
		int idx=sb4.indexOf("bc");//��ȡ�����������ַ���str��ͬ�ĵ�һ���±꣬���޷���-1
		int idx1=sb4.indexOf("bc",5);//��ȡ�ַ����д�λ��fromIndex��ʼ���ַ���str��ͬ�ĵ�һ���±꣬���޷���-1
		System.out.println(idx);//��������Sreing ��ķ��� ���� substring
		
		//�ַ������������޸�

	}

}
