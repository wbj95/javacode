package ��ļ̳�;
/*������ļ̳������Ŀ����Ϊ�˴�������
   �﷨��
   [���η��б�] class ������ extends ������{
   
   }
   java�����У�ֻ֧�ֵ��̳�,ֻ��һ���̳�һ�������ǿ��Լ�Ӽ̳�
*/
public class jicheng{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Sub c=new Sub();
      c.m1();
      //System.out.println("����");
      c.m2();
      c.m3();
      BugClass b=new BugClass();
      b.m1();
      b.m2();
      //����û����ʾ�̳������࣬Ĭ�ϼ̳�SUN�ṩ��Objiect,��toString
		jicheng a=new jicheng();
		String d=a.toString();
		System.out.println(d);
	}

}
 class Sub extends BugClass{
	 static{
		 System.out.println("���ྲ̬�����");
	 }
	 {
		 System.out.println("��������");
	 }
	 Sub(){
		 System.out.println("���๹�캯��");
	 }
	 public void m2(){
		 System.out.println("�����д����m2");
	 }
	public void m3(){
		System.out.println("����m3");
	}
}
 class BugClass{
	 {
		 System.out.println("��������");
	 }
	 static{
		 System.out.println("���ྲ̬�����");
	 }
	 BugClass(){
		 System.out.println("���๹�캯��");
	 }
	 public void m1(){
		 System.out.println("����m1");
	 }
	 public void m2(){
		 System.out.println("����m2");
	 }
 }