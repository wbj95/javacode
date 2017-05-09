package 测试;

import java.util.Scanner;
import java.util.Date;

public class Area {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		// TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
	int a,b;
	System.out.println("请输入两个整数");
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
	System.out.println("最大公约数为："+array[--j]);
	}else{System.out.println("没有最大公约数");}
	int k;
	for(k=1;k<100000;k++){
		if(k%a==0&&k%b==0){
			System.out.println("最小公倍数："+k);
			break;
		}
		}
	sc.close();
	}
}
