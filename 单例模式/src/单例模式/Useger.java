package ����ģʽ;
//����ģʽ��Ϊ�˽��JVM��ĳһ���͵�java����ֻ��һ��
//java��ʵ�ֵ���ģʽ��Ҫ˽�еĹ�������һ����̬����
//Ϊ�˽�ʡ�ڴ濪��

public class Useger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Use m1=Use.getInt();
		Use m2= Use.getInt();
      System.out.println(m1==m2);
      //==��������ǻ����������ͣ���Ƚϵ��������������������Ƿ����
      //==��������������������ͣ���Ƚϵ������������������͵��ڴ��ַ
      //false˵���������ǲ�ͬ����
	}
}
/*
 * ����ģʽ���ͣ�
 * 1 ����ʽ��������ؽ׶ξʹ���������
 * 2����ʽ���õ�����Żᴴ��
 */
class Use{//����ʽ
	//��̬���������ʱִֻ��һ��
	private static Use s;//����ʽ��private static Use s =new Use();
	//���췽��˽�л�
	private Use(){
		
	}
	//�����ṩһ��������ȡUse�ķ���
	public static Use getInt(){
		if (s==null){
			s=new Use();
		}
		return s;
	   }
	}