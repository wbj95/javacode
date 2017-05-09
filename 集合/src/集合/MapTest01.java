package 集合;

/*
 *  void clear() 清空Map
          
 boolean containsKey(Object key) 判断Map中是否包含这样的Key
        
 boolean containsValue(Object value) 判断Map中是否包含这样的value
         
 Set entrySet() 返回此映射中包含的映射关系的Set视图
         
 boolean equals(Object o) 

Object get(Object key) 通过key返回value
         
 int hashCode() 
         
 boolean isEmpty() 
           
 Set keySet() 获取Map中所有的key
          
Object put(Object key, Object value) 
        向集合中添加键值对
          
Object remove(Object key) 
          
 int size() 返回Map中键值对的个数
          
 Collection values() 获取Map集合所有的value
          

 */

import java.util.*;
public class MapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建集合
		Map map=new HashMap();//HashMap的默认初始化容量是16，默认加载因子是0.75
	
		//存储键值对
		map.put("1000", "wei");
		map.put("1001", "wvbn");
		map.put("1002", "zxc");
		map.put("1025", "asd");
		map.put("1005", "qw");
		map.put("1000", "ws");
		
		//判断键值的个数
		//Map中的key是无序不可重复的，和HashSet相同
		System.out.println(map.size());//5
		
		//判断集合中是否包含这样的key
		System.out.println(map.containsKey("1005"));//true
		
		//判断集合中是否包含这样的value
		//注意：MAp中如果key重复了，value采用的是  覆盖
		System.out.println(map.containsValue("ws"));//true
		
		//通过key获取value
		String ss="1005";
		Object v=map.get(ss);
		System.out.println(v);
		
		//通过key删除键值对
		map.remove("1005");
		System.out.println(map.size());
		
		//获取所有的value
		Collection values=map.values();
		Iterator it=values.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//获取所有的 key
		
		 Set keys=map.keySet();
		 
		 Iterator it2=keys.iterator();
		 while(it2.hasNext()){
			 
		 }
	}

}
