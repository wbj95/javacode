package �ӿ�;
/*
 * �ӿڵ����ã�
 * 1.ʹ��Ŀ�ֲ㣬���в㶼����ӿڿ��� ������Ч�����
 * 2.�ӿ�ʹ����ʹ���֮�����϶Ƚ��ͣ������ڴ����������ϵ  �ɲ��  �����л�
 * 3.�ӿںͳ����඼���õ����������ѡ��ӿڣ���Ϊ�ӿڿ��Զ�ʵ�֣���̳У�
 *   һ������˿���ʵ�ֽӿڣ������Լ̳У���������̳У�
 */
public class Test01 {//������
//���   ִ��CSL�е�logout����  ���³�������ӿڵ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService cs=new CustomerServiceImpl();//��̬
		cs.logout();//����
	}

}
 interface CustomerService{//�ͻ�ҵ���ӿ�
	 public int a = 5;
	void logout();//����һ���˳�ϵͳ
}
 //��д�ӿ�ʵ����  �����д��ȫ����ӿ�ȥʵ��
class CustomerServiceImpl implements CustomerService{
  public	void logout(){
		System.out.println("�ɹ��˳�ϵͳ");
		System.out.println(a);
	}
}
//�ӿڿ��Լ̳нӿ�
//interface A extends  CustomerService{}

//class B{}//ʵ����

//abstract class C extends B implements A{}//��������Լ̳�ʵ����,ʵ�ֽӿ�