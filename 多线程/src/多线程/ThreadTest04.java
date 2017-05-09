package 多线程;
/*
 * 某线程正在休眠，如果打断它的休眠，
 * 以下方式依靠的是异常处理机制。（不推荐）
 */

public class ThreadTest04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t=new Thread(new p4());
		//起名
		t.setName("t1");
		//启动
		t.start();
	//5s后
			Thread.sleep(5000);
   //打断休眠
		t.interrupt();
	}
}
class p4 implements Runnable{
	public void run(){
		try {
			Thread.sleep(10000);
			System.out.println("hello world!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"---->"+i);
			}
	}
}