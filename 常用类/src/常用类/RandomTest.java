package ������;
//�����������ͬ�������1~5
import java.util.*;
public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		int []a=new int[5];
		int index=0;
		while(index<5){
			int temp=r.nextInt(6);//������һ�����ڵ���0С��6�������
			System.out.println("````````");
			if(temp!=0&& !contain(a,temp))
				{System.out.println("#######");
				a[index++]=temp;}
			
		}
		for(int j=0;j<a.length;j++){System.out.println(a[j]);}
	}
	public static boolean contain(int []a,int temp){
		for(int i=0;i<a.length;i++){
			if(a[i]==temp){
			return true;
			}
		}
		return false;
	}
	
}
