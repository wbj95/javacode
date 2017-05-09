package 闹着玩;

public class EnumTest {
	//编译器自动对定义的枚举字段从0开始赋值的整数，
	enum DiscounType{
		BASIC_DISCOUNT,//0
		EXTEA_DISCOUNT,//1
		SUPER_DISCOUNT;//2
	}
	
	public static void main(String[] args) {
		int age=17;
		assert (age>10) : "age must be greater than 18";//断言
		DiscounType discount=DiscounType.BASIC_DISCOUNT,
				discount2=DiscounType.EXTEA_DISCOUNT;
		if(discount==DiscounType.BASIC_DISCOUNT)
			System.out.println("base discount for new customers:10%");
		System.out.println(discount.name());//返回枚举常量的值
		System.out.println(discount);
		System.out.println(discount.ordinal());//返回内部序列数
		System.out.println(discount2.ordinal());
		DiscounType newDiscount=discount;
		if(discount.equals(newDiscount))
			System.out.println("we are get the same memory location");
		if(discount==newDiscount)
			System.out.println("we are referring to the same location");
		int result=discount.compareTo(newDiscount);//相等
		System.out.println(result);
		int res=discount.compareTo(DiscounType.SUPER_DISCOUNT);
		System.out.println(res);
	}

}
