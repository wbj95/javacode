
public class Surper01 {
/*
 * super�����������ͣ�super�д洢�����ڴ��ַ
 * superָ��Ĳ��Ǹ������
 * super����ǰ��������и���������
 * ʲôʱ��ʹ��
 * 1.���ุ�඼��ĳ������ ���磺���ุ�඼��name����
 *   �������з��ʸ����е�name����
 *   super����ʲô�ط�
 *   1.���ڳ�Ա����    
 *   2.���ڹ��췽��
     3.this super���������ھ�̬������
 */   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Manager m = new Manager();
     m.m1();
     m.m2();
	}

}
class Employee{//Ա��
	String name ="����";
	Employee(){
		System.out.println("����");
	}
	public  void m1(){
		System.out.println("Employee");
	}
}
class Manager extends Employee{//����
	String name=" ����";
	Manager(){
		//super();
		System.out.println("����");
	}
	public  void m1(){
		super.m1();
		System.out.println("manager");
	}
	public   void m2(){//����дstatic 
		super.m1();
		super.m1();
	}
}