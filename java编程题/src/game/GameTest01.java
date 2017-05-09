package game;

import java.util.Scanner;

public class GameTest01 {
	static int c[][]=new int[100][100];

	public void game(int n) {
		int i,j;//i行，j列
		if(n<=0)return;
		if(n>2){
			game(n/2);//分治法
			//右上角
			for ( i = 0; i < n/2; i++) {
				for ( j = n/2; j < n; j++) {
					c[i][j]=c[i][j-n/2]+n/2;
				}
			}
			//左下角
			for ( i = n/2; i < n; i++) {
				for ( j = 0; j < n/2; j++) {
					c[i][j]=c[i-n/2][j+n/2];
				}
			}
			//右下角
			for ( i = n/2; i < n ; i++) {
				for ( j = n/2; j < n; j++) {
					c[i][j]=c[i-n/2][j-n/2];
				}
			}
		}else{
			c[0][0]=1;//初始化
			c[0][1]=2;
			c[1][0]=2;
			c[1][1]=1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =0;
		int flag=1;
		System.out.println("请输入参赛人数(为2^k)：");
		n = sc.nextInt();	 
		GameTest01 gameTest01 = new GameTest01();
		gameTest01.game(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

}
