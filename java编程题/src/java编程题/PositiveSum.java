package java�����;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 1.����һ������n��������к�Ϊn�������������С� 
�������趨����ָ�룬minָ���Ϊn�������������е���Сֵ��maxָ���Ϊn�����������������ֵ��sum��ʾ�����ĺ͡� 
��ʼ�����,min��max��sum ��ָ��1. 
��sumС��nʱ��max++�� 
��sum����nʱ��min++; 
��sum����nʱ������������С�
 */
public class PositiveSum {
	public static void getAns(int n) {
		int min , max , sum=1;
		for ( min = 1 ; min <= n/2; min++) {
			//System.out.println("�ϵ�");
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
