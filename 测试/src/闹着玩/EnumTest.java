package ������;

public class EnumTest {
	//�������Զ��Զ����ö���ֶδ�0��ʼ��ֵ��������
	enum DiscounType{
		BASIC_DISCOUNT,//0
		EXTEA_DISCOUNT,//1
		SUPER_DISCOUNT;//2
	}
	
	public static void main(String[] args) {
		int age=17;
		assert (age>10) : "age must be greater than 18";//����
		DiscounType discount=DiscounType.BASIC_DISCOUNT,
				discount2=DiscounType.EXTEA_DISCOUNT;
		if(discount==DiscounType.BASIC_DISCOUNT)
			System.out.println("base discount for new customers:10%");
		System.out.println(discount.name());//����ö�ٳ�����ֵ
		System.out.println(discount);
		System.out.println(discount.ordinal());//�����ڲ�������
		System.out.println(discount2.ordinal());
		DiscounType newDiscount=discount;
		if(discount.equals(newDiscount))
			System.out.println("we are get the same memory location");
		if(discount==newDiscount)
			System.out.println("we are referring to the same location");
		int result=discount.compareTo(newDiscount);//���
		System.out.println(result);
		int res=discount.compareTo(DiscounType.SUPER_DISCOUNT);
		System.out.println(res);
	}

}
