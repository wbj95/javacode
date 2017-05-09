package 单例模式;
//单例模式是为了解决JVM中某一类型的java对象只有一个
//java中实现单例模式需要私有的构造器，一个静态方法
//为了节省内存开销

public class Useger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Use m1=Use.getInt();
		Use m2= Use.getInt();
      System.out.println(m1==m2);
      //==两边如果是基本数据类型，则比较的是两个基本数据类型是否相等
      //==两边如果是引用数据类型，则比较的是两个引用数据类型的内存地址
      //false说明是两个是不同对象
	}
}
/*
 * 单例模式类型：
 * 1 饿汉式：在类加载阶段就创建对象了
 * 2懒汉式：用到对象才会创建
 */
class Use{//懒汉式
	//静态变量类加载时只执行一次
	private static Use s;//饿汉式：private static Use s =new Use();
	//构造方法私有化
	private Use(){
		
	}
	//对外提供一个公开获取Use的方法
	public static Use getInt(){
		if (s==null){
			s=new Use();
		}
		return s;
	   }
	}