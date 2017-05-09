package 多线程2;

import java.util.*;
import java.text.*;
//定时器
//作用：每隔一段时间执行一段代码
public class ThreadTest08 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//创建定时器
		Timer t=new Timer();
		//指定定时器任务,安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		t.schedule(new LogTimerTask(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2018-05-12 21:25:00 000"), 10*1000);
	}
}
//指定定时任务
class LogTimerTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
	}
	
}