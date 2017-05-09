package 内部类和匿名类;
 /*
  * 关于静态内部类
  * 1.静态内部类可以等同的看作静态变量
  *   内部类重要的作用：可以访问外部类的私有数据
  */
public class OuterClass {
    //静态变量
	private static String s1="a";
    //成员变量
	private  String s2="b";
	//静态方法
	private static void m1(){
		System.out.println("m2's method execute");
	}
	//成员方法
	public void m2(){
		System.out.println("m2's method execute");
	}
	//静态内部类可以访问控制权限的修饰符修饰
	//public protected private 缺省
	static class InterClass{
		//静态方法
		public static void m3(){
		System.out.println(s1);
		//System.out.println(s2);不行
		m1();
		//m2();不行
		}
		//成员方法
		public void m4(){
			System.out.println(s1);
			//System.out.println(s2);不行
			m1();
			//m2();不行
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        OuterClass.InterClass.m3();
        InterClass Inter=new OuterClass.InterClass();
         Inter.m4();
	}

}
