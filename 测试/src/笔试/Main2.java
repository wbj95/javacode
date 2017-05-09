package ±ÊÊÔ;

import java.util.Scanner;

public class Main2 {

	public int fun(int n, int k) {
		int sum=1;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			n = sc.nextInt();
			if (n >= 1 && n <= Math.pow(10, 9))
				break;
		}
		int k;
		while (true) {
			k = sc.nextInt();
			if (k >= 1 && k <= Math.pow(10, 9) && k <= n)
				break;
		}
		Main2 main2=new Main2();
		int tem=main2.fun(n, k);
		System.out.println(tem);
	}

}
