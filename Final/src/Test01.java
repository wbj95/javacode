/*final���ε����޷����̳�
 * final���εķ����޷�������
 * final���ξֲ�����һ����ֵ���޷����¸�ֵ
 * final���γ�Ա���������롰��ʾ�ġ���ʼ�����߿���ͨ�����췽��
 * final���γ�Ա����һ���static����
 * java�淶Ҫ�����г�������д��
 */

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//The type B cannot subclass the final class A
//final class A{}
class B extends A{}
abstract class A{
 public void m1(){ 
	final double i=100;//�޷��ٸ�ֵ
//	i=200;//(The final local variable i cannot be assigned.
	      //It must be blank and not using a compound assignment)
 }
}
/*class A{
    static	final int PI=3.14��
     final int k;���ù��췽����ֵ
     A(){
    	 k=300;
     }
}*/