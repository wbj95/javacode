package 内部类和匿名类;
/*
 * 匿名内部类：类没有名字
 */
public class Test03 {
	//静态方法
     public static void m1(A a1){
    	a1.logout();
     }
     //入口
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//调用m1方法
		//m1(new B());
		//使用匿名内部类的方式执行m1方法
		//整个这个new A(){}就是匿名内部类
		m1(new A(){
			public void logout(){
				System.out.println("退出系统");
			}
		});
	}
     //匿名内部类的优点：少定义一个类
	//缺点：无法重复使用
}
//接口
interface A{
	//退出系统
	 void logout();
}
//编写一个实现类
/*class B implements A{
	public void logout(){
		System.out.println("退出系统");
	}
}*/