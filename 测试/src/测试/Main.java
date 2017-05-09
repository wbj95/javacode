package 测试;
import java.util.Scanner;
//输出出现频率最多的数字
public class Main{
    public static void main(String[] args){
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();//输入n个整数
    	if(n>0){
    		int[] a = new int[n];//用a数组存储输入的整数
    		for(int i=0;i<n;i++)
    			a[i] = input.nextInt();//输入
    		int[] count = new int[n];//用count数组来存储整数出现的频率

    		for(int i=0;i<n-1;i++)
    			for(int j=0;j<n;j++){
    				if(a[i]==a[j]&&i!=j)
    					count[i]++;
    			}
    		int max=0;
    		for(int i=0;i<n;i++){
    			if(count[i]>max)//用max来存出现最大频率的次数
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