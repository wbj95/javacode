package 多线程;
/*
 *    三个方法：
 *    1.获取当前线程对象Thread.currentThread();
 *    2.给线程起名 t.setName();
 *    3.获取线程名字 t.getName();
 */

import java.lang.*;
public class ThreadTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//d保存的内存地址指向的线程是“主线程对象”
		Thread d=Thread.currentThread();//
		
		System.out.println(d.getName());//获取当前线程的名字
		
		Thread t1=new Thread(new P2());
		
		t1.setName("t1线程");//给线程起名
		t1.start();
		
		Thread t2=new Thread(new P2());
		t2.setName("t2线程");
		t2.start();
	}

}
class P2 implements Runnable{
	public void run(){
		Thread d=Thread.currentThread();//t保存的内存地址指向的线程是“t1线程对象”
		System.out.println(d.getName());
	}
}