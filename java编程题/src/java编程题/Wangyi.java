package java±à³ÌÌâ;

import java.util.Scanner;

public class Wangyi {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m[] = new int[n];
		int num;
		for (int i = 0; i < m.length; i++) {
			while (true) {
				int temp = scanner.nextInt();
				if (temp % 1024 == 0) {
					m[i] = temp;
					num=+m[i];
					break;
					
				}
			}

		}
	}

}
