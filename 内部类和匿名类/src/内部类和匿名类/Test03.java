package �ڲ����������;
/*
 * �����ڲ��ࣺ��û������
 */
public class Test03 {
	//��̬����
     public static void m1(A a1){
    	a1.logout();
     }
     //���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����m1����
		//m1(new B());
		//ʹ�������ڲ���ķ�ʽִ��m1����
		//�������new A(){}���������ڲ���
		m1(new A(){
			public void logout(){
				System.out.println("�˳�ϵͳ");
			}
		});
	}
     //�����ڲ�����ŵ㣺�ٶ���һ����
	//ȱ�㣺�޷��ظ�ʹ��
}
//�ӿ�
interface A{
	//�˳�ϵͳ
	 void logout();
}
//��дһ��ʵ����
/*class B implements A{
	public void logout(){
		System.out.println("�˳�ϵͳ");
	}
}*/