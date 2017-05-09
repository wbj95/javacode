package 覆盖;
      //两个类有继承关系，私有方法无法被继承,静态方法无覆盖这一说法
//以为静态方法不需要对象调用
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new B();
        a.m1();
	}
}
class A{
	A(){
		System.out.println("A");
	}
	//public static  void m1(){//静态方法，结果：A123
		public void m1(){//覆盖
		System.out.println("A123");
	}
}
class B extends A{
	B(){
		System.out.println("B");
	}
	//public static void m1(){//静态方法
		public void m1(){//覆盖
		System.out.println("B123");
	}
}