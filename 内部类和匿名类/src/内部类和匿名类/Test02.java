package �ڲ����������;



/*
 * ���ڳ�Ա�ڲ���
 * 1.��Ա�ڲ�����Ե�ͬ�Ŀ�����Ա����
 *   2.��Ա�ڲ��಻���о�̬����
 *    ��Ա�ڲ�����Է����ⲿ����������
 */
public class Test02 {
   //��̬����
	private static String s1="a";
   //��Ա����
	private  String s2="b";
	//��̬����
	private static void m1(){
		System.out.println("m2's method execute");
	}
	//��Ա����
	public void m2(){
		System.out.println("m2's method execute");
	}
	//�����ڷ������ڵ��ڲ���
	public void m3(){
	  	class interclass{
			public void m5(){
				s2="�������ڵ��ڲ���";
				s1="��̬�������ڵ��ڲ���";
			}
		}
		
	}
	
	
	//��Ա�ڲ�����Է��ʿ���Ȩ�޵����η�����
	//public protected private ȱʡ
	 class InterClass{
		//��̬����
		//public static void m3(){��Ա�ڲ��಻���о�̬����
		//System.out.println(s1);
		//System.out.println(s2);����
		//m1();
		//m2();����
	      //}
		//��Ա����
		public void m4(){
			System.out.println(s1);
			System.out.println(s2);
			m1();
			m2();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		Test02 t1=new Test02();
        InterClass inter=t1.new InterClass();
        
        inter.m4();
	}

}