package java编程题;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。 
给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。

方法1：这是前辈给出的算法，利用HashSet的特性，即不允许重复放入元素，所以一旦检测到重复元素就返回false。对于本道题来说，这种方法简洁且容易理解，能高效实现功能，但是这种方法普适性较差。
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindSameStr {
	
	public void find(String str , int l) {
		
		HashSet hs = new HashSet();
		for (int j = 0; j < l; j++) {
			char item = str.charAt(j);
			boolean b = hs.add(item);
			if(!b){
				System.out.println("第一个重复的字符为："+item);
				break ;
			}
		}
	}
	
	public void find2(String str , int l) {
		int sum = 1;
		HashMap<String, Integer> hm = new LinkedHashMap<String , Integer>();
		for (int j = 0; j < l; j++) {
			char c = str.charAt(j);
			String s = String.valueOf(c);
			boolean b = hm.containsKey(s);
			//System.out.println(sum);
			hm.put(s, sum);
			//System.out.println(b); 
			if(b) {
				System.out.println("第一个重复的字符为："+c);
				break;
			}
			/*
			if(b) {
				sum++;
				hm.put(s, sum);
			}else {
				sum = 1;
				hm.put(s, sum);
			}*/
		}
		//System.out.println(hm);
		/*
		List<String> keylist = new ArrayList<>();
		for(Entry<String, Integer> e :hm.entrySet()) {
			if(e.getValue().equals(2)) {
				keylist.add(e.getKey());
				System.out.println("第一个重复的字符为"+e.getKey());
			}
		}*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2346asyye";
		int l = str.length();
		FindSameStr f = new FindSameStr();
		//f.find(str , l);
		f.find2(str, l);
	}

}
