package ����;

/*
 *  void clear() ���Map
          
 boolean containsKey(Object key) �ж�Map���Ƿ����������Key
        
 boolean containsValue(Object value) �ж�Map���Ƿ����������value
         
 Set entrySet() ���ش�ӳ���а�����ӳ���ϵ��Set��ͼ
         
 boolean equals(Object o) 

Object get(Object key) ͨ��key����value
         
 int hashCode() 
         
 boolean isEmpty() 
           
 Set keySet() ��ȡMap�����е�key
          
Object put(Object key, Object value) 
        �򼯺�����Ӽ�ֵ��
          
Object remove(Object key) 
          
 int size() ����Map�м�ֵ�Եĸ���
          
 Collection values() ��ȡMap�������е�value
          

 */

import java.util.*;
public class MapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Map map=new HashMap();//HashMap��Ĭ�ϳ�ʼ��������16��Ĭ�ϼ���������0.75
	
		//�洢��ֵ��
		map.put("1000", "wei");
		map.put("1001", "wvbn");
		map.put("1002", "zxc");
		map.put("1025", "asd");
		map.put("1005", "qw");
		map.put("1000", "ws");
		
		//�жϼ�ֵ�ĸ���
		//Map�е�key�����򲻿��ظ��ģ���HashSet��ͬ
		System.out.println(map.size());//5
		
		//�жϼ������Ƿ����������key
		System.out.println(map.containsKey("1005"));//true
		
		//�жϼ������Ƿ����������value
		//ע�⣺MAp�����key�ظ��ˣ�value���õ���  ����
		System.out.println(map.containsValue("ws"));//true
		
		//ͨ��key��ȡvalue
		String ss="1005";
		Object v=map.get(ss);
		System.out.println(v);
		
		//ͨ��keyɾ����ֵ��
		map.remove("1005");
		System.out.println(map.size());
		
		//��ȡ���е�value
		Collection values=map.values();
		Iterator it=values.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//��ȡ���е� key
		
		 Set keys=map.keySet();
		 
		 Iterator it2=keys.iterator();
		 while(it2.hasNext()){
			 
		 }
	}

}
