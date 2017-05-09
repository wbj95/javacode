package 测试;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


//给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
public class niukeTest {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		List l=new ArrayList();
		for (int i = 0; i < n; i++) {
			long A=sc.nextInt();
			l.add(A);
			long B=sc.nextInt();
			l.add(B);
			long C=sc.nextInt();
			l.add(C);
		}
		int num=l.size();
		for (int i = 0; i <n ; i++) {
			long a=(long)l.get(i*3);
			long b=(long)l.get(i*3+1);
			long c=(long)l.get(i*3+2);
			int x=i+1;
			if(a+b>c) {
				System.out.println("Case #"+x+": "+"true");
			}
			else{
				System.out.println("Case #"+x+": "+"flase");
			}
		}
	}

}
