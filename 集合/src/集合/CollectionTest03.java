package ����;
/*
 *    boolean remove(Object o); 
 *    
 *    remove �� contains�������輯���е�Ԫ����дequals����
 *    ��ΪObject�е�equals�����Ƚ��ڴ��ַ������ʵ��ҵ���߼��в��ܱȽ��ڴ��ַ���ñȽ�����
 *    
 */

import java.util.*;
public class CollectionTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Collection c=new ArrayList();
		
		Integer i1=new Integer(10);
		c.add(i1);
		
		Integer i2=new Integer(10);
		
		c.remove(i2);
		System.out.println(c.size());//0
		
		Manager mm=new Manager("wei",11);
		//Integer i3=new Integer(mm);
		c.add(mm);
		Manager m1=new Manager("wei",11);
		c.remove(m1);
		
		System.err.println(c.size());
	}

}
/*class Manager{
	String name;
	int age;
	Manager(String naem,int age){
		this.name=name;
		this.age=age;
	}
	public boolean eqauls(Object o){
		if(this==o) return true;
		if(o instanceof Manager){
			Manager m=(Manager)o;
			if(this.name.equals(name)&&this.age==m.age) return true;
		}
		return false;
	}
}*/