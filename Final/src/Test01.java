/*final修饰的类无法被继承
 * final修饰的方法无法被覆盖
 * final修饰局部变量一旦赋值就无法重新赋值
 * final修饰成员变量，必须“显示的”初始化或者可以通过构造方法
 * final修饰成员变量一般和static连用
 * java规范要求所有常量“大写”
 */

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//The type B cannot subclass the final class A
//final class A{}
class B extends A{}
abstract class A{
 public void m1(){ 
	final double i=100;//无法再赋值
//	i=200;//(The final local variable i cannot be assigned.
	      //It must be blank and not using a compound assignment)
 }
}
/*class A{
    static	final int PI=3.14；
     final int k;调用构造方法赋值
     A(){
    	 k=300;
     }
}*/