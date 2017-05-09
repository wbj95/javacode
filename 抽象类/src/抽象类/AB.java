package 抽象类;

//import org.omg.Messaging.SyncScopeHelper;

/*
 * abstract 如何定义抽象类
 * 1.class 前加abstract
 * 2.抽象类无法实例化   无法创建对象
 * 3.虽然无法实例化  有构造方法是给子类创建对象用的
 *4. 抽象类可以定义抽象方法
 *    语法：在方法修饰符列表中加abstract,抽象方法以“；”结束  不能带有“{}”
 *    例如：public abstract void m1();
 *    5.抽象类中不一定有抽象方法  ，但抽象方法必须在抽象类中
 *    6.一个非抽象类继承抽象类必须将抽象类方法覆盖，实现，重写
 */
 public abstract class AB {//1.
     AB(){
    	 //此处有隐藏的super();
    	 System.out.println("AB");
     }
     public  void m1(){
    	 System.out.println("ab");
     }
	public static void main(String[] args) {
     //2. AB a=new AB();//Cannot instantiate the type AB
	AB a=new B();//3.
	a.m1();
	}

}
 class B extends AB{
	 public  void m1(){
		super.m1();
		 System.out.println("b");//6.
	 };
	  B(){
		  System.out.println("B");
	  };
  }
