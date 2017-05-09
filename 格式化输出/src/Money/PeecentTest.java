package Money;

import java.text.NumberFormat;

//百分比格式化
public class PeecentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat n=NumberFormat.getPercentInstance();//获取百分比对象
		System.out.println(n.format(0.633));//63%,不保留小数
		n.setMinimumFractionDigits(4);//设置4位小数
		System.out.println(n.format(0.33333));//33.3330%
	}

}
