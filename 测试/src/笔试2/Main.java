package ����2;
import java.util.LinkedList;
import java.util.List;
//����һ����ȻN,����Ȼ���ֽ�����ɲ���ȵ���Ȼ����ʹ��Щ��Ȼ��֮�͵���N,������Щ��Ȼ���Ļ����
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
		while(input>=k){//�������г�Ϊ2,3,4...w ֱ��ʣ�µ�inputһ����С��w
			in[i++]=k;
			input-=k;
			k++;
		}
		//System.out.println(i);
		//System.out.println(input);
		if(input!=0){//����жϼ�Ϊinput��ʣ��
			if(input==in[i-1]){//���ʣ����Ǹ�������w,�ͽ�w+1,ʣ���input-1,�����Ϳ��Ա�֤��inputС��w
				in[i-1]++;
				input--;
			}
			for (int j = 0; j < input; j++) {
				in[i-1-j]++;//��ʣ���input����ǰ��������+1��ֱ��input=0
			}
		}
		for (int j = 0; j < i; j++) {
			System.out.print(in[j]+" ");
		}
		for (int j = 0; j <=i-1; j++) {
			result*=in[j];//����Щ���������
		}
		System.out.println();
		System.out.print(result);
	}

}
