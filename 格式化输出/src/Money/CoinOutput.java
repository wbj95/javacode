package Money;

import java.text.NumberFormat;
import java.util.Locale;

public class CoinOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat n=NumberFormat.getCurrencyInstance();//静态方法，返回系统预设的货币形式（）
		String price =n.format(123456.123);
		System.out.println(price);//￥123,456.12,因为是中文操作系统，所有系统预设是中国货币形式
		//不同货币形式
		Locale l= Locale.US;//美元，还有其他国家货币就不写了
		NumberFormat n2=NumberFormat.getCurrencyInstance(l);
		System.out.println(n2.format(123456.12));//$123,456.12
	}

}
