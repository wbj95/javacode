package 笔试2;
import java.util.ArrayList;
import java.util.List;
/*
 * 时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 32768KB；其他语言 557056KB
题目描述：
日活跃用户数 (DAU) 是衡量一个产品表现的重要指标。
需要编写程序，根据给定的某一天的 N 条访问记录，对当天的用户总数 M 进行统计。
每个用户可能访问多次。
为了方便，我们用数字 (uid) 唯一标识每个用户。
输入
每一行包含一个 uid，遇到 0 时认为输入结束。
输入共包含 N+1 行，可认为是无序的。
输出
一个数字：去重后 uid 的数量 M。
数据范围
0 < uid < 2^63
对于 30% 的数据，0 < N < 100,000, 0 < M < 100,000
对于 100% 的数据，0 < N < 1,000,000, 0 < M < 800,000
 */
import java.util.Scanner;

public class MainTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*List<String> l=new ArrayList<String>();
		String n;
		int m=0;
		while(true){
			n=sc.nextLine();
			if(n.equals("0"))break;
			if(l.contains(n)) continue;
			else{
				l.add(n);m++;
			}
		}
		System.out.println(m);
		*/
		List<Double> l=new ArrayList<Double>();
		double n;
		int m=0;
		while(true){
			n=sc.nextDouble();
			if(n==0)break;
			if(l.contains(n)) continue;
			else{
				l.add(n);m++;
			}
		}
		System.out.println(m);
	}
}
