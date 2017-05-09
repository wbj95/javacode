package Book;

import java.util.Scanner;

public class DataTower {
	
	public static int dataTower(int [][]d,int n){
		int [][]maxAdd=new int[n][n];
		int path[][]=new int[n][n];
		//��ʼ��maxAdd[][]�����һ��
		for (int j = 0; j < n; j++) {
			maxAdd[n-1][j]=d[n-1][j];
		}
		for (int i = n-2; i >=0; i--) {//��д������
			for (int j = 0; j <=i; j++) {
				if(maxAdd[i+1][j]>maxAdd[i+1][j+1]){
					maxAdd[i][j]=d[i][j]+maxAdd[i+1][j];
					path[i][j]=j;
				}else{
					maxAdd[i][j]=d[i][j]+maxAdd[i+1][j+1];
					path[i][j]=j+1;
				}
			}
		}
		System.out.println(d[0][0]);//�������Ԫ��
		int j=path[0][0];
		for (int i = 1; i < n; i++) {
			System.out.print("-->"+d[i][j]);
			j=path[i][j];//���������ѡ����һ�����±�Ϊpath[i][j]��Ԫ��
		}
		System.out.println();
		//��ʾmaxAdd����
		for (int i = 0; i < n; i++) {
			for (int k = 0; k <=i; k++) {
				System.out.print(maxAdd[i][k]+"   ");
			}
			System.out.println();
		}
		return maxAdd[0][0];//���������ֵ��
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]d=new int[n][n];
		//��ʼ������
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <=i; j++) {
				d[i][j]=sc.nextInt();
			}
		}
		//��ʾ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.print(d[i][j]+"   ");
			}
			System.out.println();
		}
		System.out.println(dataTower(d, n));
	}

}
