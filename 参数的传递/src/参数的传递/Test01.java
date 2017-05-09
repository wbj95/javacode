package 参数的传递;

import java.util.Date;


//关于java的可变长参数
public class Test01 {
//
	public static void m1(int... i){
	System.out.println(i.length);
	for(int j=0;j<i.length;j++)	
	{
		System.out.print(i[j]+" ");
	}
	System.out.println();
	}
//如果可以精确匹配的方法，则调用该方法，不会再去执行可变长参数的方法
	public static void m1(int i){
	System.out.println(i);
	}
	//可变长参数可以等同看作数组
	public static void m2(String... aeg){
		for(int i=0;i<aeg.length;i++){
			System.out.print(aeg[i]+" ");
		}
		System.out.println();
	}
	
	public static void m3(int... j){
		for(int i=0;i<j.length;i++){
			System.out.print(j[i]+" ");
		}
		System.out.println();
	}
	
	public static void m4(Class... args) throws Exception{
		for(int i=0;i<args.length;i++)
		{
			Class c=args[i];
				System.out.println(c.newInstance());
		}
	}
	//可变长参数只能出现一次，并且只能在所有参数的最后一位
//	public static void m4(String...a,int i){}
	public static void m4(int i,String...a){}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		m1(1);//1
		m1(2,5);//2
		m1(2,6,9,8,4);//5
		m2("体育","语文","数学","美术");
		m3(4,5,6,5,41,54,54);
		m4(Date.class,Employee.class);
	}
	
	
}
