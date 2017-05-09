package java类库;
//1.自动装箱和自动拆箱是程序编译阶段的一个概念，和程序运行无关
//2.自动装箱和自动拆箱主要目的是方便程序员编码
public class 自动装箱拆箱 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i3=12;//自动装箱
		int i4=i3;//自动拆箱
		System.out.println(i3);//"12"
		System.out.println(i4);//12
		m1(123);//自动装箱
		
		Integer p1=new Integer(100);
		Integer p2=new Integer(100);
		//这里不会有自动拆箱
		System.out.println(p1==p2);//false
		//比较两个Integer类型的数据是否相等，不能用==
		//Integer已经重写了Object中的equals方法
		System.out.println(p1.equals(p2));//true
		
		//重点
		Integer p3=128;
		Integer p4=128;
		
		//上面的等同于
		//Integer p3=new Integer(128);
		//Integer p4=new Integer(128);
		
		System.out.println(p3==p4);//false
		
		//注意下面程序
		//如果数据是在[-128~127]之间，java中引入一个”整型常量池“，在方法区中
		//该整型常量池只存储-128~127之间的整数
		Integer p5=127;//这个程序不会在堆中创建对象，会直接从整型常量池中拿
		Integer p6=127;
		System.out.println(p5==p6);//true
		Integer p7=-128;
		Integer p8=-128;
		System.out.println(p7==p8);//true
		Integer p9=-129;
		Integer p10=-129;
		System.out.println(p9==p10);//false
		
	}
	public static void m1(Object o){
		System.out.println(o);
	}
}
