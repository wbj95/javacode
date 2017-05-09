package ���߳�;
/*
 * Thread.sleep(����);
 * sleep�����Ǿ�̬����
 * �÷��������ã�������ǰ�̣߳��ڳ�CPU,�ø������̡߳�
 * Thread.yield();
 * 1,�÷�����һ����̬������
 * 2�����ã���ͬһ�����ȼ����߳���λ��������λʱ�䲻�̶���
 * 3����sleep������ͬ������yieldʱ�䲻�̶���
 * 
 * Thread.join();
 * �÷����ǵȴ����߳���ֹ��
 * �ϲ��̣߳�
 */

public class ThreadTest03 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//�߳����ȼ�
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
		
		try {//Thread�е�run�������׳��쳣��������дrun����֮����run����������λ���ϲ���ʹ��throws
			//����run�����е��쳣ֻ����try catch
			//Thread.sleep(1000);
			Thread.sleep((int)Math.random()*100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
}