package Money;

import java.text.DecimalFormat;
import java.text.NumberFormat;

//数值格式化
public class NumberFormatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat n=NumberFormat.getNumberInstance();
		System.out.println(n.format(123456.123456));//123,456.123只保留三位，四舍五入
		/*
		 * 1,"0"表示一位数值，如果没有这位，则显示0
		 * 2，“#”表示任何位数的整数，如果没有，则不显示。在小数点模式后使用，只表示一位小数，四舍五入
		 * 3,"."表示小数点模式
		 * 4，","与“0”一起使用，表示逗号
		 * 
		 */
		NumberFormat f=new DecimalFormat("00000,000");
		System.out.println(f.format(-123456.556));//-00,123,457,不显示小数，因为四舍五入
		//#
		f=new DecimalFormat("#");
		System.out.println(f.format(-123456.556));//-123457
		f=new DecimalFormat("#00");
		System.out.println(f.format(0));//00
		//.
		f=new DecimalFormat(".00");
		System.out.println(f.format(-.567));//-.57
		f=new DecimalFormat("0.00");
		System.out.println(f.format(-.567));//-0.57
		f=new DecimalFormat("#.#");
		System.out.println(f.format(-1234.557));//-1234.6
	}

}
