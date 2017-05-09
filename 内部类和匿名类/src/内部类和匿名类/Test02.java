package 内部类和匿名类;



/*
 * 关于成员内部类
 * 1.成员内部类可以等同的看作成员变量
 *   2.成员内部类不能有静态声明
 *    成员内部类可以访问外部的所有数据
 */
public class Test02 {
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
	//定义在方法体内的内部类
	public void m3(){
	  	class interclass{
			public void m5(){
				s2="方法体内的内部类";
				s1="静态方法体内的内部类";
			}
		}
		
	}
	
	
	//成员内部类可以访问控制权限的修饰符修饰
	//public protected private 缺省
	 class InterClass{
		//静态方法
		//public static void m3(){成员内部类不能有静态声明
		//System.out.println(s1);
		//System.out.println(s2);不行
		//m1();
		//m2();不行
	      //}
		//成员方法
		public void m4(){
			System.out.println(s1);
			System.out.println(s2);
			m1();
			m2();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		Test02 t1=new Test02();
        InterClass inter=t1.new InterClass();
        
        inter.m4();
	}

}