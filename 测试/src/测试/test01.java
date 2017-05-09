package ≤‚ ‘;
public class test01 {
	
	public int p(){
		int x=0;
		try {
			return V();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			return V2();
		}
	}
	
	public int V(){
		System.out.println("try");
		return 1;
	}
	public int V2(){
		System.out.println("finally");
		return 2;
	}
	
	public static void main(String[] args) {
		test01 test01=new test01();
		int b=test01.p();
		System.out.println(b);
		boolean bb=true?false:true==true?false:true;
		System.out.println(bb);
		int i=1;
		int j=1;
		boolean cc=true?true:++i==2?false:true;
		System.out.println(i+" "+cc);
		boolean dd=false?true:++j==2?false:true;
		System.out.println(j+" "+dd);
	}
}