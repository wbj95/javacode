package Money;

import java.text.NumberFormat;

//�ٷֱȸ�ʽ��
public class PeecentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat n=NumberFormat.getPercentInstance();//��ȡ�ٷֱȶ���
		System.out.println(n.format(0.633));//63%,������С��
		n.setMinimumFractionDigits(4);//����4λС��
		System.out.println(n.format(0.33333));//33.3330%
	}

}
