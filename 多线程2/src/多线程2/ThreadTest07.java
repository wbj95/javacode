package ���߳�2;

//�ػ��߳�
//���������û��߳̽��������ػ��߳��˳���
//�ػ��߳�һ�㶼������ѭ��
public class ThreadTest07 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//�����߳�
		Thread t=new Processor();
		//�����߳�����
		t.setName("t1");
		//��t1����ػ��߳�
		t.setDaemon(true);
		//��ʼִ���߳�
		t.start();
		//���߳�
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
