package �ڲ����������;
 /*
  * ���ھ�̬�ڲ���
  * 1.��̬�ڲ�����Ե�ͬ�Ŀ�����̬����
  *   �ڲ�����Ҫ�����ã����Է����ⲿ���˽������
  */
public class OuterClass {
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
	//��̬�ڲ�����Է��ʿ���Ȩ�޵����η�����
	//public protected private ȱʡ
	static class InterClass{
		//��̬����
		public static void m3(){
		System.out.println(s1);
		//System.out.println(s2);����
		m1();
		//m2();����
		}
		//��Ա����
		public void m4(){
			System.out.println(s1);
			//System.out.println(s2);����
			m1();
			//m2();����
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        OuterClass.InterClass.m3();
        InterClass Inter=new OuterClass.InterClass();
         Inter.m4();
	}

}
