package ����;

import java.util.Scanner;
import java.util.Date;

public class Area {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		// TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
	int a,b;
	System.out.println("��������������");
	a=sc.nextInt();
	b=sc.nextInt();
	int array[]=new int[(a+b)/2];
	int i,j=0;
	for(i=2;i<=a+b/2;i++){
		if(a%i==0&&b%i==0){
           array[j]=i;
           j++;
		}
	}
	if(j>0){
	System.out.println("���Լ��Ϊ��"+array[--j]);
	}else{System.out.println("û�����Լ��");}
	int k;
	for(k=1;k<100000;k++){
		if(k%a==0&&k%b==0){
			System.out.println("��С��������"+k);
			break;
		}
		}
	sc.close();
	}
}
