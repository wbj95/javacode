package Money;

import java.math.BigDecimal;

//BigDecimal 用于处理对更大精度的数据处理
public class BigDecimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal bigNumber=new BigDecimal("89.123456789123456789");
		BigDecimal bigRate=new BigDecimal(1000);
		BigDecimal bigResult=new BigDecimal(0.0);
		bigResult=bigNumber.multiply(bigRate);
		System.out.println(bigResult.toString());//89123.456789123456789000
		double dDate=bigNumber.doubleValue();
		System.out.println(dDate);//89.12345678912345，精度丢失
	}

}
