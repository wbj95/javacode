package ����;
/*
 * ��һ���ܳ��Ķ��飬��������һ����n���ˡ����е��˷�Ϊ���ࣺ���죬С͵����ͨ�ˡ�������������˴�ǰ������1��n��ţ����Ϊi��������Ϊj���˵ľ���Ϊi��j֮��ľ���ֵ��
ÿһ��������һ������ֵx����ʾ���ܹ������������벻����x�������ˣ�С͵�����췢�ֵ��ҽ�������һ������������ӵ�����֪�������������У�һ���ж��ٸ�С͵�ᱻ���췢����
���������У���һ��һ����n(1<=n<=100000)��������һ����һ������Ϊn���ַ��������α�ʾ�����е�ÿһ���ˡ����ĳһλ��1-9��ĳ������x����ʾ��һλ��һ������ֵΪx�ľ��죻���ĳһλ���ַ�X��ʾ��һλ��С͵�����ĳһλ���ַ�#��ʾ����һ����ͨ�ˡ����뱣֤������������ַ���
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public int fun(int n, String s) {
		char[] ss = s.toCharArray();
		int flage;
		int count = 0;
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] >= '1' && ss[i] <= '9') {
				String tem = String.valueOf(ss[i]);
				flage = Integer.valueOf(tem);
				for (int j = i - flage; j <= i + flage; j++) {
					if (j >= 0 && j < s.length()) {
						if(ss[j]=='X'){
							ss[j]='m';
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String s = null;
		Main main = new Main();
		n = sc.nextInt();
		s = sc.next();
		int result = main.fun(n, s);
		System.out.println(result);
	}

}
