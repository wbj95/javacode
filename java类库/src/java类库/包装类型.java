package java���;
/*
 * java�а��ֻ����������Ͷ�Ӧ�İ�װ����
 *     ������������			��װ����
 *   
 *     byte					java.lang.Byte;
 *     short				java.lang.Short
 *     int 					java.lang.Integer
 *     long					java.lang.Long
 *     
 *     float				java.lang.Float;
 *     double				java.lang.Double;
 *     
 *     boolean				java.lang.Boolean;
 *     
 *     char					java.lang.Character;
 *     ˼����
 *         java���ṩ�İ��ֻ����������Ͳ�������Ϊʲôjava�л�Ҫ�ṩ��Ӧ�İ�װ���ͣ�
 *         ����
 */

public class ��װ���� {
	//���	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������������
		Byte b=10;
		//��������
		Byte b1=new Byte(b);
		
		Character c='s';
		char c1=new Character(c);
		m1(b1);//Byte�Ѿ���Object�е�toString������д
		m1(c1);
	}
	//���󣺹涨m1�������Խ���java���κ�һ����������
	//m1������������byte���͵����ݣ����Խ�byte�����Ȱ�װ��java.lang.Byte;�ٴ�����
	
	public static void m1(Object o){
		System.out.println(o);
	}
}
