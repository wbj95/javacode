package ≤‚ ‘;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
	int []a=new int[6];
	public void rotateString(String A, int n, int p) {
        // write code here
        List<String> list = new ArrayList<String>();
        //list.add(A);
       
        char[] c=A.toCharArray();
        char[] d=null;
        for (int i = 0; i < n; i++) {
			//System.out.println(c[i]);
        	d[i] = c[i];
		}
        
    }
	
	public static void main(String[] args) {
		//new Z();
		 // write code here
		Main1 main1 = new Main1();
		main1.rotateString("abcdefg", 5, 2);
	}
	
}
class X {
	Y y =new Y();
	public X() {
		System.out.println("X");
	}
}

class Y {
	public Y() {
		System.out.println("Y");
	}
}

class Z extends X {
	Y y = new Y();
	public Z(){
		System.out.println("Z");
	}
}
