package java编程题;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 1.输入一个正数n，输出所有和为n的连续正数序列。 
分析：设定两个指针，min指向和为n的连续正数序列的最小值，max指向和为n的连续正数序列最大值。sum表示真正的和。 
初始情况下,min、max和sum 都指向1. 
当sum小于n时，max++； 
当sum大于n时，min++; 
当sum等于n时，输出整个序列。
 */
public class PositiveSum {
	public static void getAns(int n) {
		int min , max , sum=1;
		for ( min = 1 ; min <= n/2; min++) {
			//System.out.println("断点");
			for (max = min ; max < n ; max++) {
				if(min > max) {
					break;
				}
				sum = min + max;
				//System.out.println(sum);
				if(sum == n) {
					System.out.println("("+min+","+max+")");
				}
			}
		}
	}
	
	public static void GetAns(int n) {
		int sum =0;
		List<Integer> list = new ArrayList<Integer>();
		for ( int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				//System.out.println(i);
				list.add(j);
				sum +=j;
				if(sum ==n) {
					//System.out.println(i+"---");
					Iterator<Integer> iterator	= list.iterator();
					while(iterator.hasNext()) {
						System.out.println(iterator.next());
					}
					list.clear();
					sum = 0;
					System.out.println();
					break;
				}
				if(sum > n) {
					list.clear();
					sum = 0;
					break;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getAns(15);
		GetAns(15);
	}

}
