package ����;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardShuffleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] cardArray={"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		List<String> cardList=Arrays.asList(cardArray);//��cardArrayԪ�ظ��Ƶ�����
		Collections.shuffle(cardList);//����ϴ�Ʒ���
		System.out.println("cardList="+cardList);
		Collections.shuffle(cardList, new Random(10));
		//����ϴ�Ʒ�������ʹ���κ������
		System.out.println("cardList="+cardList);
	}

}
