package 接口;
/*
 * 接口的作用：
 * 1.使项目分层，所有层都面向接口开发 ，开发效率提高
 * 2.接口使代码和代码之间的耦合度降低，就像内存条和主板关系  可插拔  随意切换
 * 3.接口和抽象类都可用的情况，优先选择接口，因为接口可以多实现，多继承，
 *   一个类除了可以实现接口，还可以继承（保留了类继承）
 */
public class Test01 {//主方法
//入口   执行CSL中的logout方法  以下程序面向接口调用
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService cs=new CustomerServiceImpl();//多态
		cs.logout();//调用
	}

}
 interface CustomerService{//客户业户接口
	 public int a = 5;
	void logout();//定义一个退出系统
}
 //编写接口实现类  该类编写完全面向接口去实现
class CustomerServiceImpl implements CustomerService{
  public	void logout(){
		System.out.println("成功退出系统");
		System.out.println(a);
	}
}
//接口可以继承接口
//interface A extends  CustomerService{}

//class B{}//实体类

//abstract class C extends B implements A{}//抽象类可以继承实体类,实现接口