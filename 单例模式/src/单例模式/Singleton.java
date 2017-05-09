package 单例模式;

public class Singleton {
		//利用一个静态变量来记录唯一实例
	private static Singleton uniqueInstace;
	
	//私有构造器,只有Singleton类内才能调用
   private	Singleton(){}
   
   //实例化对象
   //懒汉
  /* public static Singleton getInstace(){
	   if(uniqueInstace==null){
		   uniqueInstace= new Singleton();
	   }
	   return uniqueInstace;
   }
   */
   
   /*
    * 使用同步的方法，解决多线程灾难
    * 但使用这种方法会影响执行效率
    */
  /* public synchronized static Singleton getInstace(){
	   if(uniqueInstace==null){
		   uniqueInstace= new Singleton();
	   }
	   return uniqueInstace;
   }
   */
   
   /*
    * 使用“急切"创建实例，而不用延迟实例化的做法
    * 饿汉
    */
   /*private static Singleton uniqueInstance = new Singleton(); 
   public static Singleton getInstance() { 
       return uniqueInstance; 
   }
   */
   
   
   /*
    * 用 双重检查加锁，在getInstace()中减少使用同步
    * 这种做法可以大大减少使用方法的时间耗费
    */
   public  static Singleton getInstace(){
	   
	   if(uniqueInstace==null){
		   synchronized(Singleton.class){
			   if(uniqueInstace==null){
				   uniqueInstace= new Singleton();
			   }
			   }
		   }
		   
	   return uniqueInstace;
   }
}
