package 测试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalindrome {
	//蛮力法
	public String longestPalindrome(String s) {
        String result=null;
        int maxLen=0;
        if(s.length()==1) return s;//如果输入字符串只有一个，就直接输出
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
	//判断是不是回文串
	public boolean panduan(String s){
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();//倒置
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
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	}
}
