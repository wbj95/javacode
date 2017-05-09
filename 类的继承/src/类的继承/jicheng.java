package 类的继承;
/*引用类的继承最初的目的是为了代码重用
   语法：
   [修饰符列表] class 子类名 extends 父类名{
   
   }
   java语言中，只支持单继承,只能一个继承一个，但是可以间接继承
*/
public class jicheng{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Sub c=new Sub();
      c.m1();
      //System.out.println("憋陶");
      c.m2();
      c.m3();
      BugClass b=new BugClass();
      b.m1();
      b.m2();
      //主类没有显示继承其他类，默认继承SUN提供的Objiect,有toString
		jicheng a=new jicheng();
		String d=a.toString();
		System.out.println(d);
	}

}
 class Sub extends BugClass{
	 static{
		 System.out.println("子类静态代码块");
	 }
	 {
		 System.out.println("子类代码块");
	 }
	 Sub(){
		 System.out.println("子类构造函数");
	 }
	 public void m2(){
		 System.out.println("子类改写父类m2");
	 }
	public void m3(){
		System.out.println("子类m3");
	}
}
 class BugClass{
	 {
		 System.out.println("父类代码块");
	 }
	 static{
		 System.out.println("父类静态代码块");
	 }
	 BugClass(){
		 System.out.println("父类构造函数");
	 }
	 public void m1(){
		 System.out.println("父类m1");
	 }
	 public void m2(){
		 System.out.println("父类m2");
	 }
 }