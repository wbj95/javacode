package ����;
      //�������м̳й�ϵ��˽�з����޷����̳�,��̬�����޸�����һ˵��
//��Ϊ��̬��������Ҫ�������
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new B();
        a.m1();
	}
}
class A{
	A(){
		System.out.println("A");
	}
	//public static  void m1(){//��̬�����������A123
		public void m1(){//����
		System.out.println("A123");
	}
}
class B extends A{
	B(){
		System.out.println("B");
	}
	//public static void m1(){//��̬����
		public void m1(){//����
		System.out.println("B123");
	}
}