package Money;

import java.text.DecimalFormat;
import java.text.NumberFormat;

//��ֵ��ʽ��
public class NumberFormatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat n=NumberFormat.getNumberInstance();
		System.out.println(n.format(123456.123456));//123,456.123ֻ������λ����������
		/*
		 * 1,"0"��ʾһλ��ֵ�����û����λ������ʾ0
		 * 2����#����ʾ�κ�λ�������������û�У�����ʾ����С����ģʽ��ʹ�ã�ֻ��ʾһλС������������
		 * 3,"."��ʾС����ģʽ
		 * 4��","�롰0��һ��ʹ�ã���ʾ����
		 * 
		 */
		NumberFormat f=new DecimalFormat("00000,000");
		System.out.println(f.format(-123456.556));//-00,123,457,����ʾС������Ϊ��������
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
