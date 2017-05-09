package java类库;
/*
 * 以java.lang.Integer;类型为例，讲解八种类型
 */

public class IntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取int类型的最大值和最小值
		System.out.println("最大值："+Integer.MAX_VALUE);//最大值：2147483647
		System.out.println("最小值："+Integer.MIN_VALUE);//最小值：-2147483648
		//以int推byte
		System.out.println("最大值："+Byte.MAX_VALUE);//最大值：127
		System.out.println("最小值："+Byte.MIN_VALUE);//最大值：127
		//创建Integer类型的对象
		Integer a=new Integer("123");//String-->Integer
		Integer b=new Integer(124);//int-->Integer;
		
		//Integer c=new Integer("abc");//编译能通过，但是运行的时候会报异常  数字格式化异常
		//NumberFormatException
		System.out.println(a);
		System.out.println(b);
		//int-->Integer;
		Integer s=new Integer(156);
		Integer d=Integer.valueOf(10);
		//Integer-->int
		int i2=b.intValue();
		System.out.println(i2+1);
		//String-->int
		int age=Integer.parseInt("123");//必须要是数字
		System.out.println(age+1);
		//String-->Integer
		Integer q=Integer.valueOf("123");
		//String-->double
		Double age1=Double.parseDouble("3.0");
		System.out.println(age1+2.0);
		//int-->二进制
		String i3=Integer.toBinaryString(10);
		System.out.println(i3);
		//int-->十六进制
		String i4=Integer.toHexString(10);
		System.out.println(i4);
		//int-->八进制
		String i5=Integer.toOctalString(10);
		System.out.println(i5);
	}

}
