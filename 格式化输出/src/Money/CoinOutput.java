package Money;

import java.text.NumberFormat;
import java.util.Locale;

public class CoinOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat n=NumberFormat.getCurrencyInstance();//��̬����������ϵͳԤ��Ļ�����ʽ����
		String price =n.format(123456.123);
		System.out.println(price);//��123,456.12,��Ϊ�����Ĳ���ϵͳ������ϵͳԤ�����й�������ʽ
		//��ͬ������ʽ
		Locale l= Locale.US;//��Ԫ�������������һ��ҾͲ�д��
		NumberFormat n2=NumberFormat.getCurrencyInstance(l);
		System.out.println(n2.format(123456.12));//$123,456.12
	}

}
