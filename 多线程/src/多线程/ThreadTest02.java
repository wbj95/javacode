package ���߳�;
/*
 *    ����������
 *    1.��ȡ��ǰ�̶߳���Thread.currentThread();
 *    2.���߳����� t.setName();
 *    3.��ȡ�߳����� t.getName();
 */

import java.lang.*;
public class ThreadTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//d������ڴ��ַָ����߳��ǡ����̶߳���
		Thread d=Thread.currentThread();//
		
		System.out.println(d.getName());//��ȡ��ǰ�̵߳�����
		
		Thread t1=new Thread(new P2());
		
		t1.setName("t1�߳�");//���߳�����
		t1.start();
		
		Thread t2=new Thread(new P2());
		t2.setName("t2�߳�");
		t2.start();
	}

}
class P2 implements Runnable{
	public void run(){
		Thread d=Thread.currentThread();//t������ڴ��ַָ����߳��ǡ�t1�̶߳���
		System.out.println(d.getName());
	}
}