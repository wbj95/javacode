package 笔试;
/*
 * 有一条很长的队伍，队伍里面一共有n个人。所有的人分为三类：警察，小偷和普通人。将队伍里面的人从前到后由1到n编号，编号为i的人与编号为j的人的距离为i与j之差的绝对值。
每一个警察有一个能力值x，表示他能够监视与他距离不超过x的所有人，小偷被警察发现当且仅当他被一个或多个警察监视到。你知道在整条队伍中，一共有多少个小偷会被警察发现吗？
输入有两行，第一行一个数n(1<=n<=100000)，接下来一行有一个长度为n的字符串，依次表示队伍中的每一个人。如果某一位是1-9的某个数字x，表示这一位是一个能力值为x的警察；如果某一位是字符X表示这一位是小偷；如果某一位是字符#表示这是一个普通人。输入保证不会出现其它字符。
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public int fun(int n, String s) {
		char[] ss = s.toCharArray();
		int flage;
		int count = 0;
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] >= '1' && ss[i] <= '9') {
				String tem = String.valueOf(ss[i]);
				flage = Integer.valueOf(tem);
				for (int j = i - flage; j <= i + flage; j++) {
					if (j >= 0 && j < s.length()) {
						if(ss[j]=='X'){
							ss[j]='m';
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String s = null;
		Main main = new Main();
		n = sc.nextInt();
		s = sc.next();
		int result = main.fun(n, s);
		System.out.println(result);
	}

}
