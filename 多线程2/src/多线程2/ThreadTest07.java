package 多线程2;

//守护线程
//其他所有用户线程结束，则守护线程退出；
//守护线程一般都是无限循环
public class ThreadTest07 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//创建线程
		Thread t=new Processor();
		//设置线程名字
		t.setName("t1");
		//把t1变成守护线程
		t.setDaemon(true);
		//开始执行线程
		t.start();
		//主线程
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"->"+i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Processor extends Thread{
	int i=0;
	public void run(){
		while(true){
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName()+"->"+i);
		}
	}
}
