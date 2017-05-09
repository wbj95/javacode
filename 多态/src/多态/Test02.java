package 多态;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test02 t = new Test02();
	}
	//构造方法
	public  Test02(){
		System.out.println("构造方法");
	}
	public void Test02( float b , boolean c ,int a){}
	//不是构造方法
	public void Test02( float b , int a,boolean c){
		System.out.println("不是构造方法");
	}//重载不看修饰符和返回类型，和方法名和参数类型顺序有关
}
