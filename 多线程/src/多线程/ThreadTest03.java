package 多线程;
/*
 * Thread.sleep(毫秒);
 * sleep方法是静态方法
 * 该方法的作用：阻塞当前线程，腾出CPU,让给其他线程。
 * Thread.yield();
 * 1,该方法是一个静态方法，
 * 2，作用：给同一个优先级的线程让位，但是让位时间不固定。
 * 3，和sleep方法相同，就是yield时间不固定。
 * 
 * Thread.join();
 * 该方法是等待该线程终止。
 * 合并线程，
 */

public class ThreadTest03 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//线程优先级
      System.out.println(Thread.MAX_PRIORITY);//10
      System.out.println(Thread.MIN_PRIORITY);//1
      System.out.println(Thread.NORM_PRIORITY);//5
		
		
		
		Thread d1=new p3();
      Thread d2=new p3();
      d1.setName("t1");
      d2.setName("t2");
      
      System.out.println(d1.getPriority());//5
      System.out.println(d2.getPriority());//5
      
      d1.start();
      d2.start();
      for(int i=0;i<20;i++){
    	  System.out.println(Thread.currentThread().getName()+"--->"+i);
    	  Thread.sleep((int )Math.random()*100000);
      }
	}
}
class p3 extends Thread{
	public void run(){
		for(int i=0;i<=50;i++){
		System.out.println(Thread.currentThread().getName()+"--->"+i);
		
		try {//Thread中的run方法不抛出异常，所以重写run方法之后，在run方法的声明位置上不能使用throws
			//所以run方法中的异常只能用try catch
			//Thread.sleep(1000);
			Thread.sleep((int)Math.random()*100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
}