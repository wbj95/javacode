package �쳣;
/*
 * 1.�쳣��ʲô��
 *    ��һ���쳣ģ�������ʵ�����С����������¼�
 *    �ڶ���java�в��á��ࡱȥģ���쳣
 *    ���������ǿ��Դ��������
 *         ���磺 NullPointerExceptin c= 0x1234;
 *         c���������ͣ�c�б�����ڴ��ַָ����еĶ��󡰶���
 *         �������һ����NullPointerExceptin����
 *         �������ͱ�ʾ��ʵ���ڵ��쳣�¼�
 *         NullPointerExceptin��һ���쳣
 *         
 *        �����١�����һ���쳣
 *        �����������١�����һ���쳣�¼�
 *  2.�쳣���Ƶ�����      
 *    java����Ϊ�����ṩһ�����Ƶ��쳣������ƣ�
 *    �����ǣ��������쳣�¼���Ϊ���������ϸ����Ϣ��
 *    ����ͨ�������Ϣ�����ԶԳ������һЩ����ʹ������ӽ�׳
 */
public class ExceptionTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int a=10;
         int b=0;
         //int c=a/b;//ArithmeticException c=0x3456;
         //����Ĵ�������쳣����û�д���������Ĵ��벻��ִ�У�ֱ���˳�
         //System.out.println("��");
         if(b!=0){
        	 int c=a/b;
        	 System.out.println(c);
         }else{
        	 System.out.println("�����쳣");
         }
	}

}
/*
 * ���ϳ������ͨ������������ʱ�����쳣����ʾ����ĳ���쳣�¼���
 * JVM�����̨���������Ϣ��
 * ���ʣ�����ִ�й����з����������쳣�¼���JVMΪ���Ǵ�����һ��ArithmeticException���͵Ķ���
 * ������������������ϸ���쳣��Ϣ������JVM����������е���Ϣ���������̨
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	at �쳣.ExceptionTest01.main(ExceptionTest01.java:9)
 */
