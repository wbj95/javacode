package �㷨�α�;
//�޸��۰�����㷨ʹ֮�ܹ����з�Χ���ҡ���ν��Χ������Ҫ�ҳ��ڸ���ֵa��b֮�������Ԫ��
import java.util.Scanner;

public class Test03 {

	public void Fun(int []A,int min,int max,int low,int high){
		int m=(low+high)/2;
		if(A[m]<min)
			Fun(A, min, max, m, high);
		else if(A[m]>max)
			Fun(A, min, max, low, m);
		else{
			for (int i = m; A[i]>=min&&i>=low; i--) {
				System.out.print(A[i]+" ");
			}
			for (int i = m+1; A[i] <=max&&i<=high; i++) {
				System.out.print(A[i]+" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int []A={2,5,7,9,11,33,55,66};
		Test03 test03=new Test03();
		int min=sc.nextInt();
		int max=sc.nextInt();
		test03.Fun(A, min, max,0,A.length-1);
	}
}
