
public class Surper01 {
/*
 * super不是引用类型，super中存储不是内存地址
 * super指向的不是父类对象
 * super代表当前子类对象中父类型特征
 * 什么时候使用
 * 1.子类父类都有某个数据 例如：子类父类都有name属性
 *   在子类中访问父类中的name属性
 *   super用在什么地方
 *   1.用在成员方法    
 *   2.用在构造方法
     3.this super都不能用在静态方法中
 */   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Manager m = new Manager();
     m.m1();
     m.m2();
	}

}
class Employee{//员工
	String name ="张三";
	Employee(){
		System.out.println("父类");
	}
	public  void m1(){
		System.out.println("Employee");
	}
}
class Manager extends Employee{//经理
	String name=" 李四";
	Manager(){
		//super();
		System.out.println("子类");
	}
	public  void m1(){
		super.m1();
		System.out.println("manager");
	}
	public   void m2(){//不能写static 
		super.m1();
		super.m1();
	}
}