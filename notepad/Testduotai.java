public class Testduotai {

	public static void main(String[] args) {
	/*
	 * ����ת���ֱ���Ϊ�Զ�����ת��
	 * �����͵�����ָ�������͵Ķ���
	 * �����Ϊ�����׶Σ�����׶Σ����н׶�
	 * �������׶�ֻ֪��a��Animal����
	 * ����������ʱ���е�ʵ�ʶ�����cat����
	 * ���Գ����ڱ���׶�a�����ð���Animal���е�eat��������̬�󶨣�
	 * ���������еĽ׶ζ������cat�е�eat��������̬�󶨣�
	 */
	Animal a=new Animal();
	a.eat();
	Animal c=new cat();
    c.eat();
    //����ת�� ǿ������ת��
    Animal a1=new cat();
    cat a2=(cat)a1;
    a2.move();
	}
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
	if(a3 instanceof cat){
		cat c3=(cat)a3;
		c3.eat();
	}

}
class cat extends Animal{
	public void eat(){
		System.out.println("è�ڳԶ���");
		}
	public void move(){
		System.out .println("è����è��");
	}
}
class Dog extends Animal{
	public void eat(){
		System.out.println("���ڳԶ���");
	}
}
class Animal{
	public void eat(){
	System.out.println("�����ڳԶ���");
	}
}