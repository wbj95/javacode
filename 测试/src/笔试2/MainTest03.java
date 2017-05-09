package ±  ‘2;

import java.util.Scanner;

public class MainTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		char[]c=s.toCharArray();
		char [][]r=new char[5][3];
		for (int i = 0; i < c.length; i++) {
			switch(c[i]){
			case 0:for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < r.length; j2++) {
					if(j2==1&&(j==1||j==2||j==3))continue;
					r[j][j2]='*';
				}
			}
			case 1:for (int m = 0; m < 5; m++) {
				r[m][0]='*';
			}break;
			case 2:System.out.println("***");
					System.out.println("  *");
					System.out.println("***");
					System.out.println("*");
					System.out.println("***");
					break;
			case 3:System.out.println("***");
					System.out.println("  *");
					System.out.println("***");
					System.out.println("  *");
					System.out.println("***");
					break;
			case 4:System.out.println("* *");
			       System.out.println("* *");
			       System.out.println("***");
			       System.out.println("  *");
			       System.out.println("  *");
			       break;
			case 5:System.out.println("***");
			       System.out.println("*");
			       System.out.println("***");
			       System.err.println("  *");
			       System.out.println("***");
			       break;
			}
		}
	}

}
