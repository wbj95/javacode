package �ڲ����������;
/*
 * �ֲ��ڲ����ͬ�ھֲ�����
 * �ص㣺�ֲ��ڲ����ڷ��ʾֲ�����ʱ�򣬾ֲ���������ʹ��final����
 */
public class OuterClass02 {
	//����
     public void m1(){
    	 //�ֲ�����
    	 final int i=100;
    	 //�ֲ�����
    	 //�ֲ��ڲ��಻���÷��ʿ���Ȩ�����η�����
    	 class InterClass{
    		 //�ֲ��ڲ��಻���о�̬����
    		 //public static void m4(){}
    		 //��Ա����
    		 public void m2(){
    			 System.out.println(i);
    		 }
    	 }
    	 //����m2
    	 InterClass i1=new InterClass();
    	 i1.m2();
     }
	//���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          OuterClass02 o1=new OuterClass02();
          //����m1
          o1.m1();
	}

}
