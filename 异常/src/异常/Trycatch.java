package �쳣;
import java.io.*;
/*
 * �����쳣�ĵڶ��ַ�ʽ����׽  try...catch...
 * �﷨��
 *    try{
 *      ���ܳ��ֵ��쳣;
 *    }catch(�쳣����1 ����){
 *       �����쳣�Ĵ���;
 *    }catch(�쳣����2 ����){
 *    �����쳣�Ĵ���;
 *    }...
 *    
 *    1.catch�������д���
 *    2.���Ǵ��ϵ���catch�����С�����쳣���������쳣���в�׽
 *    3.try...catch..�����ִ��1��catch��䣬ִ�н���֮��try...catch..�ͽ�����
 *    
 *    ����getMessage��ptintStackTrace����Ӧ��
 *    
 *    
 */
public class Trycatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try{
    	//����ִ�е��˴�������FileNotFoundException���͵��쳣
    	//JVM���Զ�����һ��FileNotFoundException���͵Ķ��󣬸ö�����ڴ��ַ��ֵ��catch�����е�e����
    	
    	FileInputStream fls=new FileInputStream("asd");
    	//����Ĵ�������쳣��try����Ĵ��벻��ִ�У�ֱ�ӽ���catch������ִ��
    	System.out.println("1235");
    	fls.read();
    	
    }catch(FileNotFoundException e){//e�ڴ��ַָ����е��Ǹ�������FileNotFoundException���͵��¼�
    	System.out.println("��ȡ���ļ�������");
    	//FileNotFoundException��Object�е�toString������д
    	System.out.println(e);//java.io.FileNotFoundException: asd (ϵͳ�Ҳ���ָ�����ļ���)
    	e.printStackTrace();//��ӡ�쳣��ջ��Ϣ
    	//һ������¶���ʹ�ø÷���ȥ���Գ���
    	/*
    	 * java.io.FileNotFoundException: asd (ϵͳ�Ҳ���ָ�����ļ���)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at �쳣.Trycatch.main(Trycatch.java:30)

    	 */
    	
    	String msg=e.getMessage();
    	System.out.println(msg);//asd (ϵͳ�Ҳ���ָ�����ļ���)

    }catch(IOException e){
    	System.out.println("����IO�쳣");
    }
    System.out.println("hello world");
	}

}
