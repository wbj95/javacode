package �ӿ�;
/*
 * �����ͷ�����֮��Ľӿ�
 * ���������ĳ�������ӿ�����
 * �����������ĳ�������ӿ�����
 */
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //��������
		Engine e1=new YAMAHA();//Engine����д��YAMAHA
       Car c=new Car(e1);//��������
    c.TextEngine();//��������
    c.e=new HONDA();//��һ��������
    c.TextEngine();
	}
}
 interface Engine{//�ӿ�
	void start();
}
 class YAMAHA implements Engine{//����YAMAHA������
	public  void start(){
		System.out.println("YAMAHA����");
	}
}
 class HONDA implements Engine{
	 public void start(){
		 System.out.println("HONDA����");
	 }
 }
 class Car{//��������
	 Engine e;//��������ӿڱ��  Field����
	 Car(Engine e){//Constructor���췽��
		 this.e=e;
	 }
	 public void TextEngine(){//�����ܲ�������
		e.start();//����ӿڵ���
	 }
 }
 