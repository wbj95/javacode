package 多线程;
/*
 * java语言中实现多线程的一种方法：
 *    第一步:继承java.lang.Thread;
 *    第二步：重写run方法
 *       
 *       第二种方法：
 *       第一步：写一个类实现java.lang.Runnable;接口
 *       第二步：实现run方法
 */
public class ThreadTest01{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建线程
		Thread t=new p();
		//启动线程
		t.start();//这段代码执行瞬间结束，告诉JVM再分配一个新的线程给t线程
		            //run不需要程序员手动调用，系统线程启动之后自动调用run方法
		//创建线程
		Thread t1=new Thread(new p1());
		//启动
		t1.start();
		//t.run();   //这是普通方法调用，这样做程序只有一个线程，run方法结束之后，下面程序才能继续执行
		for(int i=0;i<=10;i++){
			System.out.println("main-->"+i);
		}
		//有了多线程之后，main方法结束只是主线程中没有方法栈帧了
		//但是其他线程或者其他栈中还有栈帧。
		//main方法结束，线程可能还在运行。	
	}
}
//定义线程
class p extends Thread{
	//重写run方法
	public  void run(){
		Thread tt =new p();
		//tt.start();
		for(int i=0;i<=3;i++){
		System.out.println("run-->"+i);
		}
	}
}


//推荐用这种方式，，因为类实现接口之外还保留了类的继承
class p1 implements Runnable{
	public void run(){
		for(int i=0;i<=30;i++){
			System.out.println("run1-->"+i);
			}
	}
}