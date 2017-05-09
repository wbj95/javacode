package java编程题;

import java.util.Scanner;

public class Test03 {
	int V[][] = new int[100][100];

	int max(int a, int b){
		if(a>=b)return a;
		else
			return b;
	}
	
   void f(int n, int w[], int v[], int C) {
		int i,j;
		for(i=0;i<=n;i++)
			V[i][0]=0;
		for(j=0;j<= C;j++)
			V[0][j]=0;
		for(i=1;i<= n;i++){
			for(j=1;j<= C;j++){
				if(j<w[i])
					V[i][j]=V[i-1][j];
				else
					V[i][j]=max(V[i-1][j],V[i-1][j-w[i]]+v[i]);
			}
		}
		for ( i = 0; i <= n; i++) {
			for ( j = 0; j <= C; j++) {
				System.out.print(V[i][j]+" ");
			}
			System.out.println();
		}
		//System.out.println("最多价值"+V[n-1][C]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int s;
		int n;
		int C;
		int w[] = new int[100];
		int v[] =new int [100];
		//int x[] = new int[15];
		//int n=0, i;
		//int C=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入背包最大值：");
		C = scanner.nextInt();
		System.out.println("请输入物品数量:");
		n = scanner.nextInt();
		System.out.println("请分别输入物品的重量：");
		for (int j = 1; j <=n; j++) {
			w[j] = scanner.nextInt();
		}
		System.out.println("请分别输入物品的价值：");
		for (int j = 1; j <=n; j++) {
			v[j] = scanner.nextInt();
		}
		Test03 test03=new Test03();
		test03.f(n,w,v,C);
		//test03.f(n, w, v,  C);
		//System.out.println("最大物品价值为："+s);
	
	}

}
