package �ӿ�;
/*�ӿ���һ���������ͣ����Ե�ͬ������
 * 1.��ζ���  �﷨
 *    [���η�] interface �ӿ���{}
 * 2.�ӿ���ֻ�ܳ��ֳ��������󷽷�
 * 3.�ӿ���һ������ĳ����࣬�ӿ�����ȫ����
 * 4.�ӿ���û�й��췽�����޷���ʵ����
 * 5.�ӿںͽӿ�֮����Զ�̳�
 * 6.һ�������ʵ�ֶ���ӿڣ�����ʵ�ֿ��Ե�ͬ�Ŀ������̳С���
 * 7.һ���ǳ�����ʵ�ֽӿڣ��轫�ӿ����з�����ʵ��/��д/���ǡ�   
 */
public interface A {//1.
	//������������public static final���Σ�
     public static final String SUCCESS="success";
     public static final double PI=3.14;
     byte MX_VALUE=127;//(public static final����ʡ��)
     //���󷽷����ӿ������г��󷽷�����public abstract��
     public abstract void m1();
     void m2();//ͬ������ʡ��
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String a="123";
		  String c="a"+"b"+a;
		  String d="a"+"b"+"c";
		     int b=a.length();
		     System.out.println(b);
		     System.out.println(a=="abc");
		     System.out.println(a=="123");
		     System.out.println(c=="ab123");
		     System.out.println(d=="abc");
	}
}
interface B{
	void m1();
}
interface C{
	void m2();
}
interface D{
	void m3();
}
interface E extends B,C,D{//5.
	void m4();
}
//implements��ʵ�ֵ���˼  �ؼ���  ��extends����ͬ
class MyClass implements B,C{//6.
	 public void m1(){
		 System.out.println("m1");
	 }
	 public void m2(){}
}
class F implements E{//7.
	public void m1(){}
	public void m2(){}
	public void m3(){}
	public void m4(){}
}