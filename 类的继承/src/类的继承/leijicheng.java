package ��ļ̳�;

public class leijicheng {
	public static void main(String[] args) {
     DetAccout st=new DetAccout();
     st.Setno("007");
     //st,Accout(001,55);�޷����ù��췽��
     st.Getno();//��ӷ���˽������
     //System.out.println(st.ID);�޷�ֱ�ӷ���
	}	
}
/*
 * �����˻�  ������  ������  subclass
 * ������԰Ѹ�������ݶ��̳й���������˽������
 * ���������޷�ֱ�ӷ���˽�����ݣ����ǿ��Լ�ӷ���
 * ���췽���޷����̳�
 */
class DetAccout extends Accout{
	double asd;
}
//�˻���
//���� ���� ���� superclass
class Accout{
	//�˺�
	private String ID;
	//���
	double balance;
	//���췽��
	Accout(){}
	Accout(String Id,double balance){
		this.ID=ID;
		this.balance=balance;
	}
	public void Setno(String ID){
		this.ID=ID;
	}
	public void Getno(){
		System.out.println(ID);
	}
	/*
	 * public String Getno(){
	 *   return ID
	 * }
	 */
}