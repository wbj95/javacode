package ���߳�;
/*
 * ĳ�߳��������ߣ��������������ߣ�
 * ���·�ʽ���������쳣������ơ������Ƽ���
 */

public class ThreadTest04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t=new Thread(new p4());
		//����
		t.setName("t1");
		//����
		t.start();
	//5s��
			Thread.sleep(5000);
   //�������
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