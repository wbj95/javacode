package 接口;
/*接口是一种引用类型，可以等同看作类
 * 1.如何定义  语法
 *    [修饰符] interface 接口名{}
 * 2.接口中只能出现常量，抽象方法
 * 3.接口是一种特殊的抽象类，接口是完全抽象
 * 4.接口中没有构造方法，无法被实例化
 * 5.接口和接口之间可以多继承
 * 6.一个类可以实现多个接口（这里实现可以等同的看作“继承”）
 * 7.一个非抽象类实现接口，需将接口所有方法“实现/重写/覆盖”   
 */
public interface A {//1.
	//常量（必须用public static final修饰）
     public static final String SUCCESS="success";
     public static final double PI=3.14;
     byte MX_VALUE=127;//(public static final可以省略)
     //抽象方法（接口中所有抽象方法都是public abstract）
     public abstract void m1();
     void m2();//同样可以省略
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String a="123";
		  String c="a"+"b"+a;
		  String d="a"+"b"+"c";
		     int b=a.length();
		     System.out.println(b);
		     System.out.println(a=="abc");
		     System.out.println(a=="123");
		     System.out.println(c=="ab123");
		     System.out.println(d=="abc");
	}
}
interface B{
	void m1();
}
interface C{
	void m2();
}
interface D{
	void m3();
}
interface E extends B,C,D{//5.
	void m4();
}
//implements是实现的意思  关键字  和extends意义同
class MyClass implements B,C{//6.
	 public void m1(){
		 System.out.println("m1");
	 }
	 public void m2(){}
}
class F implements E{//7.
	public void m1(){}
	public void m2(){}
	public void m3(){}
	public void m4(){}
}