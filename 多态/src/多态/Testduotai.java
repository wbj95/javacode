package ��̬;
/*
 * ����java�е�����ת�ͺ�����ת��
 * ����ת�ͣ���upcasting):�ӡ���������������
 * ����ת�ͣ���downcasting):��������������
 * ��������ת�ͻ�������ת�ͣ������඼�����м̳й�ϵ
 */

public class Testduotai {
	/*
	 * ����ת���ֱ���Ϊ�Զ�����ת��
	 * �����͵�����ָ�������͵Ķ���
	 * �����Ϊ�����׶Σ�����׶Σ����н׶�
	 * �������׶�ֻ֪��a��Animal����
	 * ����������ʱ���е�ʵ�ʶ�����cat����
	 * ���Գ����ڱ���׶�a�����ð���Animal���е�eat��������̬�󶨣�
	 * ���������еĽ׶ζ������cat�е�eat��������̬�󶨣�
	 */
	public static void main(String[] args) {
		String ee[];
	Animal a=new Animal();
	a.eat();//�����ڳԶ���
	Animal c=new Cat();
    c.eat();//è�ڳԶ���
    //����ת�� ǿ������ת��
    Animal a1=new Cat();
    Cat a2=(Cat)a1;
    a2.move();
    /*
	 Animal a2=new Dog();
	  cat c2=(cat)a2;Dog���cat��֮��û�м̳У��޷�����ǿ������ת��
	  c2.eat();���ڷ��գ�Ϊ�˱��⣬java����instanceof
	  �÷���
	  1��instanceof���������������boolean
	  2:(����  instanceof ����)---->>ture/fase
	  ���磺(a instanceof cat)��������ture ����a����ָ��ѵö�����cat����
	 */

    Animal a3=new Dog();
    System.out.println(a3 instanceof Cat);
    if(a3 instanceof Cat){
    Cat c3=(Cat)a3;
    }
	}
}
class Cat extends Animal{
	Cat(){
		System.out.println("è�Ĺ��캯��");
	}
	public void eat(){
		System.out.println("è�ڳԶ���");
		}
	public void move(){
		System.out .println("è����è��");
	}
}
class Dog extends Animal{
	Dog(){
		System.out.println("���Ĺ��캯��");
	}
	public void eat(){
		System.out.println("���ڳԶ���");
	}
}
class Animal{
	Animal(){
		System.out.println("����Ĺ��캯��");
	}
	public void eat(){
	System.out.println("�����ڳԶ���");
	}
}