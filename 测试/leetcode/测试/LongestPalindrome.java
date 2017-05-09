package ����;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalindrome {
	//������
	public String longestPalindrome(String s) {
        String result=null;
        int maxLen=0;
        if(s.length()==1) return s;//��������ַ���ֻ��һ������ֱ�����
        for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j < s.length(); j++) {
				int len=j-i;
				if(len>maxLen){
					String crr=s.substring(i, j+1);
					if(panduan(crr)){
						if(len>maxLen){
							maxLen=len;
							result=crr;
						}
					}
				}
				
			}
		}
        if(maxLen==0) return s.substring(0,1);
        return result;
    }
	//�ж��ǲ��ǻ��Ĵ�
	public boolean panduan(String s){
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();//����
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==sb.charAt(i)){
				count++;
			}
		}
		if(count==s.length())return true;
		else return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String s=sc.nextLine();
		long startTime = System.currentTimeMillis();
		LongestPalindrome l=new LongestPalindrome();
		System.out.println(l.longestPalindrome(s));
		long endTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺"+(endTime-startTime)+"ms");
	}
}
