package java�����;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * ����һ���ַ����������һ����Ч�㷨���ҵ���һ���ظ����ֵ��ַ��� 
����һ���ַ���(��һ��ȫΪ��ĸ)A�����ĳ���n���뷵�ص�һ���ظ����ֵ��ַ�����֤�ַ��������ظ��ַ����ַ����ĳ���С�ڵ���500��

����1������ǰ���������㷨������HashSet�����ԣ����������ظ�����Ԫ�أ�����һ����⵽�ظ�Ԫ�ؾͷ���false�����ڱ�������˵�����ַ��������������⣬�ܸ�Чʵ�ֹ��ܣ��������ַ��������Խϲ
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
				System.out.println("��һ���ظ����ַ�Ϊ��"+item);
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
				System.out.println("��һ���ظ����ַ�Ϊ��"+c);
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
				System.out.println("��һ���ظ����ַ�Ϊ"+e.getKey());
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
