package �쳣;
import java.io.*;
public class ����throws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //m1();
        //ʹ��throws�����쳣�������������쳣������ж����
        //˭���þͻ��׸�˭
        //�����m1������������쳣����Ϊ���õ��������ף�����JVM��JVM�����쳣�ͻ��˳�JVM������Ĵ���Ͳ���ִ��
        //System.out.println("Hello World");
  
	//�����Ĵ���
       try{
        	m1();
        }catch(FileNotFoundException e){}
        System.out.println("Hello World");
	}
		public static void m1() throws FileNotFoundException{
			m2();
		}
		public static void m2() throws FileNotFoundException{
			m3();
		}
		public static void m3() throws FileNotFoundException{
			new FileInputStream("c:/asd.txt");
		}
	

}
/*�ڳ���ִ�й����з�����FileNotFoundException���͵��쳣
 * javaΪ���Ǵ�����һ��FileNotFoundException���͵Ķ���
 * �ö�����Я�����µ���Ϣ
 * JVM���𽫸ö������Ϣ��ӡ������̨
 * ����JVMͣ���˳��������
 * Exception in thread "main" java.io.FileNotFoundException: c:\asd.txt (ϵͳ�Ҳ���ָ�����ļ���)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at �쳣.����throws.m3(����throws.java:26)
	at �쳣.����throws.m2(����throws.java:23)
	at �쳣.����throws.m1(����throws.java:20)
	at �쳣.����throws.main(����throws.java:7)

 */
