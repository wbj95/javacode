package ����;
import java.util.Scanner;
//�������Ƶ����������
public class Main{
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();//����n������
    	if(n>0){
    		int[] a = new int[n];//��a����洢���������
    		for(int i=0;i<n;i++)
    			a[i] = input.nextInt();//����
    		int[] count = new int[n];//��count�������洢�������ֵ�Ƶ��

    		for(int i=0;i<n-1;i++)
    			for(int j=0;j<n;j++){
    				if(a[i]==a[j]&&i!=j)
    					count[i]++;
    			}
    		int max=0;
    		for(int i=0;i<n;i++){
    			if(count[i]>max)//��max����������Ƶ�ʵĴ���
    				max = count[i];
    		}
    		for(int i=0;i<n;i++){
    			if(count[i] == max){
    				System.out.print(a[i]);
    				break;
    			}
    		}
    	}
    }
}