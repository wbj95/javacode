
public class hanshu2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      hanshu2.m1(3);
      System.out.println("hello world");//return��Ӱ������
	}
    public static void m1(int i){
    	for(;i<10;i++){
    		if(i==5){
    			break;//�����д��return;�ӷ������ڴ˽�������
    		}
    		System.out.println(i);
    	}
    	System.out.println("hello world");
    }
}
