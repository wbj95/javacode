package ���߳�2;

import java.util.*;
import java.text.*;
//��ʱ��
//���ã�ÿ��һ��ʱ��ִ��һ�δ���
public class ThreadTest08 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//������ʱ��
		Timer t=new Timer();
		//ָ����ʱ������,����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		t.schedule(new LogTimerTask(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2018-05-12 21:25:00 000"), 10*1000);
	}
}
//ָ����ʱ����
class LogTimerTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
	}
	
}