package ������;

//import org.omg.Messaging.SyncScopeHelper;

/*
 * abstract ��ζ��������
 * 1.class ǰ��abstract
 * 2.�������޷�ʵ����   �޷���������
 * 3.��Ȼ�޷�ʵ����  �й��췽���Ǹ����ഴ�������õ�
 *4. ��������Զ�����󷽷�
 *    �﷨���ڷ������η��б��м�abstract,���󷽷��ԡ���������  ���ܴ��С�{}��
 *    ���磺public abstract void m1();
 *    5.�������в�һ���г��󷽷�  �������󷽷������ڳ�������
 *    6.һ���ǳ�����̳г�������뽫�����෽�����ǣ�ʵ�֣���д
 */
 public abstract class AB {//1.
     AB(){
    	 //�˴������ص�super();
    	 System.out.println("AB");
     }
     public  void m1(){
    	 System.out.println("ab");
     }
	public static void main(String[] args) {
     //2. AB a=new AB();//Cannot instantiate the type AB
	AB a=new B();//3.
	a.m1();
	}

}
 class B extends AB{
	 public  void m1(){
		super.m1();
		 System.out.println("b");//6.
	 };
	  B(){
		  System.out.println("B");
	  };
  }
