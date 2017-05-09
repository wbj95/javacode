package 算法课本;

import java.util.Scanner;

import javax.net.ssl.SSLContext;
/*
 * 编写程序，生成n个元素的全排列 。
例如：输入n=3, {1,2,3}
           输出123,132,213,231,312,321

 */
public class Test01 {

	//阶乘
	public int fun(int n){
		int sum=1;
		if(n==1)return 1;
		for (int i = 2; i <= n; i++) {
			sum=sum*i;
		}
		return sum;
	}
	
	//全排列
	public void Fun(char []A,int start,int end){
		if(start==end){//递归到最后
			for (int i = 0; i <=end; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}else{
			for (int i = start; i <=end; i++) {
				char temp =A[start];//交换数组第一个元素与后续元素
				A[start]=A[i];
				A[i]=temp;
				Fun(A, start+1, end);//递归全排列
				//恢复
				temp=A[start];
				A[start]=A[i];
				A[i]=temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		char []A=new char[100];
			for (int i = 0; i < n; i++) {
				A[i]=scanner.next().charAt(0);
			}
		Test01 test01=new Test01();
		test01.Fun(A, 0, n-1);
	}

}
