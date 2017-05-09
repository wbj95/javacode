package ≤‚ ‘;

public class Test002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k;
		 for(int n=100;n<=1000;n++){
		 i=n/100;
		 j=(n-i*100)/10;
		 k=n%10;
		 if(n==i*i*i+j*j*j+k*k*k)
		 System.out.print(n+" ");
		 }
		 System.out.println();

	}

}
