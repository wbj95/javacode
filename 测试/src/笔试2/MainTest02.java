package ����2;
import java.util.ArrayList;
import java.util.List;
/*
 * ʱ�����ƣ�C/C++���� 2000MS���������� 4000MS
�ڴ����ƣ�C/C++���� 32768KB���������� 557056KB
��Ŀ������
�ջ�Ծ�û��� (DAU) �Ǻ���һ����Ʒ���ֵ���Ҫָ�ꡣ
��Ҫ��д���򣬸��ݸ�����ĳһ��� N �����ʼ�¼���Ե�����û����� M ����ͳ�ơ�
ÿ���û����ܷ��ʶ�Ρ�
Ϊ�˷��㣬���������� (uid) Ψһ��ʶÿ���û���
����
ÿһ�а���һ�� uid������ 0 ʱ��Ϊ���������
���빲���� N+1 �У�����Ϊ������ġ�
���
һ�����֣�ȥ�غ� uid ������ M��
���ݷ�Χ
0 < uid < 2^63
���� 30% �����ݣ�0 < N < 100,000, 0 < M < 100,000
���� 100% �����ݣ�0 < N < 1,000,000, 0 < M < 800,000
 */
import java.util.Scanner;

public class MainTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*List<String> l=new ArrayList<String>();
		String n;
		int m=0;
		while(true){
			n=sc.nextLine();
			if(n.equals("0"))break;
			if(l.contains(n)) continue;
			else{
				l.add(n);m++;
			}
		}
		System.out.println(m);
		*/
		List<Double> l=new ArrayList<Double>();
		double n;
		int m=0;
		while(true){
			n=sc.nextDouble();
			if(n==0)break;
			if(l.contains(n)) continue;
			else{
				l.add(n);m++;
			}
		}
		System.out.println(m);
	}
}
