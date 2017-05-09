package 内部类和匿名类;
/*
 * 局部内部类等同于局部变量
 * 重点：局部内部类在访问局部变量时候，局部变量必须使用final修饰
 */
public class OuterClass02 {
	//方法
     public void m1(){
    	 //局部变量
    	 final int i=100;
    	 //局部变量
    	 //局部内部类不能用访问控制权限修饰符修饰
    	 class InterClass{
    		 //局部内部类不能有静态声明
    		 //public static void m4(){}
    		 //成员方法
    		 public void m2(){
    			 System.out.println(i);
    		 }
    	 }
    	 //调用m2
    	 InterClass i1=new InterClass();
    	 i1.m2();
     }
	//入口
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          OuterClass02 o1=new OuterClass02();
          //调用m1
          o1.m1();
	}

}
