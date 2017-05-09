package 集合;
/*
 *    boolean remove(Object o); 
 *    
 *    remove 和 contains方法都需集合中的元素重写equals方法
 *    因为Object中的equals方法比较内存地址，在现实的业务逻辑中不能比较内存地址，该比较内容
 *    
 */

import java.util.*;
public class CollectionTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建集合
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