package ตÝน้;

public class digui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
      int retult=M1(10);
      System.out.println(retult);
    		  }
    public static int M1(int n){
    	if(n==1){
    		return 1;
    	}
    	else{
    	return n+M1(n-1);
    	}
    	
    }
}
