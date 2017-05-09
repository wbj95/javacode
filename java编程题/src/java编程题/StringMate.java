package java编程题;

import java.util.Scanner;

//串匹配问题BF
public class StringMate {

	void findString(char[] S1, char[] T1) {
		int n =S1.length;
		int m =T1.length;
		//System.out.println(n);
		//System.out.println(m);
		int index = 0;
		int i = 0, j = 0;
			while(i<n&&j<m){
				if(S1[i]==T1[j]){i++;j++;}
				else{index++;i=index;j=0;};
			}
		
		if(j==m) {System.out.println("匹配起始下标"+index);}
		else {System.out.println("无");}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入主串S：");
		String S = sc.nextLine();
		System.out.println("请输入模式T：");
		String T = sc.nextLine();
		StringMate mate = new StringMate();
		char[] S1 = S.toCharArray();
		char[] T1 =T.toCharArray();
		mate.findString(S1, T1);
	}

}
