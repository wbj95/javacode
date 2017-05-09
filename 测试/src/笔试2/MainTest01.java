package 笔试2;
/*
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 给定两个整型数组[a1, a2, ...., am]，[b1, b2, ..., bn]
输入格式如下，第一行给定第一个数组的大小m，接下来的m行为其数组元素a1 -- am，每行一个元素；第m+1行为第二个数组的大小n，接下来的n行为其数组元素b1 -- bn，也是每行一个元素。示例如下：
m
a1
a2
…
am
n
b1
b2
…
bn
​
输出
两个数组中相同的元素，以空格分隔在一行中显示，显示顺序为其在第二个数组中出现的顺序。
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainTest01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		List l=new ArrayList<>();
		int t;
		for (int i = 0; i < m; i++) {
			t=sc.nextInt();
			l.add(t);
		}
		int n=sc.nextInt();
		int r2[]=new int[n];
		int j=0;
		List l2=new ArrayList<>();
		for (int i = 0; i < n; i++) {
			t=sc.nextInt();
			if(l.contains(t))l2.add(t);
		}
		Iterator tt=l2.iterator();
		while(tt.hasNext()){
			System.out.print(tt.next()+" ");
		}
	}

}
