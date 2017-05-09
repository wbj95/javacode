package 笔试2;
import java.util.LinkedList;
import java.util.List;
//输入一个自然N,将自然数分解成若干不相等的自然数，使这些自然数之和等于N,并且这些自然数的积最大
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int input=sc.nextInt();
		int result=1;
		int k=2;
		List l=new LinkedList();
		int []in=new int[100];
		int i=0;
		while(input>=k){//先让序列成为2,3,4...w 直到剩下的input一个数小于w
			in[i++]=k;
			input-=k;
			k++;
		}
		//System.out.println(i);
		//System.out.println(input);
		if(input!=0){//这个判断即为input的剩余
			if(input==in[i-1]){//如果剩余的那个数等于w,就将w+1,剩余的input-1,这样就可以保证，input小于w
				in[i-1]++;
				input--;
			}
			for (int j = 0; j < input; j++) {
				in[i-1-j]++;//将剩余的input，往前的数依次+1，直到input=0
			}
		}
		for (int j = 0; j < i; j++) {
			System.out.print(in[j]+" ");
		}
		for (int j = 0; j <=i-1; j++) {
			result*=in[j];//将这些数依次相乘
		}
		System.out.println();
		System.out.print(result);
	}

}
