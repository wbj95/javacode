package 异常;
import java.io.*;
/*
 * 处理异常的第二种方式：捕捉  try...catch...
 * 语法：
 *    try{
 *      可能出现的异常;
 *    }catch(异常类型1 变量){
 *       处理异常的代码;
 *    }catch(异常类型2 变量){
 *    处理异常的代码;
 *    }...
 *    
 *    1.catch语句块可以写多个
 *    2.但是从上到下catch必须从小类型异常到大类型异常进行捕捉
 *    3.try...catch..中最多执行1个catch语句，执行结束之后try...catch..就结束了
 *    
 *    关于getMessage和ptintStackTrace方法应用
 *    
 *    
 */
public class Trycatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try{
    	//程序执行到此处发生了FileNotFoundException类型的异常
    	//JVM会自动创建一个FileNotFoundException类型的对象，该对象的内存地址赋值给catch语句块中的e变量
    	
    	FileInputStream fls=new FileInputStream("asd");
    	//上面的代码出现异常，try语句块的代码不再执行，直接进入catch语句块中执行
    	System.out.println("1235");
    	fls.read();
    	
    }catch(FileNotFoundException e){//e内存地址指向堆中的那个对象是FileNotFoundException类型的事件
    	System.out.println("读取的文件不存在");
    	//FileNotFoundException将Object中的toString方法重写
    	System.out.println(e);//java.io.FileNotFoundException: asd (系统找不到指定的文件。)
    	e.printStackTrace();//打印异常堆栈信息
    	//一般情况下都会使用该方法去调试程序
    	/*
    	 * java.io.FileNotFoundException: asd (系统找不到指定的文件。)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at 异常.Trycatch.main(Trycatch.java:30)

    	 */
    	
    	String msg=e.getMessage();
    	System.out.println(msg);//asd (系统找不到指定的文件。)

    }catch(IOException e){
    	System.out.println("其他IO异常");
    }
    System.out.println("hello world");
	}

}
