package ���߳�;
/*
 * java������ʵ�ֶ��̵߳�һ�ַ�����
 *    ��һ��:�̳�java.lang.Thread;
 *    �ڶ�������дrun����
 *       
 *       �ڶ��ַ�����
 *       ��һ����дһ����ʵ��java.lang.Runnable;�ӿ�
 *       �ڶ�����ʵ��run����
 */
public class ThreadTest01{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����߳�
		Thread t=new p();
		//�����߳�
		t.start();//��δ���ִ��˲�����������JVM�ٷ���һ���µ��̸߳�t�߳�
		            //run����Ҫ����Ա�ֶ����ã�ϵͳ�߳�����֮���Զ�����run����
		//�����߳�
		Thread t1=new Thread(new p1());
		//����
		t1.start();
		//t.run();   //������ͨ�������ã�����������ֻ��һ���̣߳�run��������֮�����������ܼ���ִ��
		for(int i=0;i<=10;i++){
			System.out.println("main-->"+i);
		}
		//���˶��߳�֮��main��������ֻ�����߳���û�з���ջ֡��
		//���������̻߳�������ջ�л���ջ֡��
		//main�����������߳̿��ܻ������С�	
	}
}
//�����߳�
class p extends Thread{
	//��дrun����
	public  void run(){
		Thread tt =new p();
		//tt.start();
		for(int i=0;i<=3;i++){
		System.out.println("run-->"+i);
		}
	}
}


//�Ƽ������ַ�ʽ������Ϊ��ʵ�ֽӿ�֮�⻹��������ļ̳�
class p1 implements Runnable{
	public void run(){
		for(int i=0;i<=30;i++){
			System.out.println("run1-->"+i);
			}
	}
}