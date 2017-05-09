package 集合;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardShuffleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] cardArray={"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		List<String> cardList=Arrays.asList(cardArray);//将cardArray元素复制到集合
		Collections.shuffle(cardList);//调用洗牌方法
		System.out.println("cardList="+cardList);
		Collections.shuffle(cardList, new Random(10));
		//调用洗牌方法，可使用任何随机数
		System.out.println("cardList="+cardList);
	}

}
