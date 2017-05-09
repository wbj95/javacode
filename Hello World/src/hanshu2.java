
public class hanshu2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      hanshu2.m1(3);
      System.out.println("hello world");//return不影响这里
	}
    public static void m1(int i){
    	for(;i<10;i++){
    		if(i==5){
    			break;//如果是写成return;子方法就在此结束程序
    		}
    		System.out.println(i);
    	}
    	System.out.println("hello world");
    }
}
