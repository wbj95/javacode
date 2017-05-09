package 异常;
import java.io.*;
public class 深入throws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //m1();
        //使用throws处理异常不是真正处理异常而是推卸责任
        //谁调用就会抛给谁
        //上面的m1方法如果出现异常，因为采用的是向上抛，给了JVM，JVM遇到异常就会退出JVM，下面的代码就不会执行
        //System.out.println("Hello World");
  
	//真正的处理
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
/*在程序执行过程中发生了FileNotFoundException类型的异常
 * java为我们创建了一个FileNotFoundException类型的对象
 * 该对象中携带以下的信息
 * JVM负责将该对象的信息打印给控制台
 * 并且JVM停掉了程序的运行
 * Exception in thread "main" java.io.FileNotFoundException: c:\asd.txt (系统找不到指定的文件。)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at 异常.深入throws.m3(深入throws.java:26)
	at 异常.深入throws.m2(深入throws.java:23)
	at 异常.深入throws.m1(深入throws.java:20)
	at 异常.深入throws.main(深入throws.java:7)

 */
