package �㷨�α�;

import java.util.Scanner;

import javax.net.ssl.SSLContext;
/*
 * ��д��������n��Ԫ�ص�ȫ���� ��
���磺����n=3, {1,2,3}
           ���123,132,213,231,312,321

 */
public class Test01 {

	//�׳�
	public int fun(int n){
		int sum=1;
		if(n==1)return 1;
		for (int i = 2; i <= n; i++) {
			sum=sum*i;
		}
		return sum;
	}
	
	//ȫ����
	public void Fun(char []A,int start,int end){
		if(start==end){//�ݹ鵽���
			for (int i = 0; i <=end; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}else{
			for (int i = start; i <=end; i++) {
				char temp =A[start];//���������һ��Ԫ�������Ԫ��
				A[start]=A[i];
				A[i]=temp;
				Fun(A, start+1, end);//�ݹ�ȫ����
				//�ָ�
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
