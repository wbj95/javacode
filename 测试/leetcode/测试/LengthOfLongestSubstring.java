package 测试;
/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question.

Show Tags
Show Similar Problems

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
        int maxleght=1;//最大值
        char[]r=s.toCharArray();//转变成字符数组
        if(s==null||s.length()<=0)return 0;//
        int i;
        int j=0;
        List l=new ArrayList();
        for ( i = 0; i < r.length; i++) {
        	l.add(r[i]);
			for ( j = i+1; j < r.length; j++) {
				if(l.contains(r[j])){
					int temp=j-i;
					if(temp>maxleght) maxleght=temp;
					break;
				}
				l.add(r[j]);
				if(j-i==r.length-1){
					maxleght=r.length;
				}
				if(j==r.length-1) {
					int temp=l.size();
					if(temp>maxleght)
					maxleght=l.size();
				}
			}
			l.clear();
		}
        return maxleght;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		LengthOfLongestSubstring l=new LengthOfLongestSubstring();
		int result=l.lengthOfLongestSubstring(s);
		System.out.println(result);
	}

}
