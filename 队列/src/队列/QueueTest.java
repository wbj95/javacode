package ╤сап;

import java.util.Queue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import javax.management.Query;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Object> qq=new LinkedList<Object>();
		qq.offer(2);
		qq.offer(3);
		qq.offer(4);
		System.out.println(qq.size());
		System.out.println(qq.poll());
		System.out.println(qq.peek());
	}
}
