package 异常;
/*
 * 1.异常是什么？
 *    第一，异常模拟的是现实世界中“不正常”事件
 *    第二，java中采用“类”去模拟异常
 *    第三，类是可以创建对象的
 *         例如： NullPointerExceptin c= 0x1234;
 *         c是引用类型，c中保存的内存地址指向堆中的对象“对象”
 *         这个对象一定是NullPointerExceptin类型
 *         这个对象就表示真实存在的异常事件
 *         NullPointerExceptin是一类异常
 *         
 *        ”抢劫“就是一类异常
 *        ”张三被抢劫“就是一个异常事件
 *  2.异常机制的作用      
 *    java语言为我们提供一个完善的异常处理机制：
 *    作用是：程序发生异常事件后，为我们输出详细的信息。
 *    程序通过这个信息，可以对程序进行一些处理，使程序更加健壮
 */
public class ExceptionTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int a=10;
         int b=0;
         //int c=a/b;//ArithmeticException c=0x3456;
         //上面的代码出现异常，”没有处理“，下面的代码不会执行，直接退出
         //System.out.println("猪");
         if(b!=0){
        	 int c=a/b;
        	 System.out.println(c);
         }else{
        	 System.out.println("程序异常");
         }
	}

}
/*
 * 以上程序编译通过，但是运行时出现异常，表示发生某个异常事件。
 * JVM向控制台输出如下信息：
 * 本质：程序执行过程中发生了算数异常事件，JVM为我们创建了一个ArithmeticException类型的对象
 * 并且这个对象包含了详细的异常信息，并且JVM将这个对象中的信息输出到控制台
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	at 异常.ExceptionTest01.main(ExceptionTest01.java:9)
 */
