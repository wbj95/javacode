package 集合;
//   boolean contains(Object o);判断集合中是否包含某个元素
//   boolean remove(Object 0); 删除集合中某个元素
//存储在集合中的元素都要去重写equals方法
import java.util.*;
public class CollectioinTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建集合
		Collection c=new ArrayList();
		
		//创建Integer类型对象
		Integer m1=new Integer(10);
		c.add(m1);//添加对象
		System.out.println(c.contains(m1));//true
		
		Integer m2=new Integer(10);
		System.err.println(c.contains(m2));//true
		//contains方法底层调用的是equals方法，如果equals返回true，就是包含
		Manager m3=new Manager("wei",11);
		c.add(m3);
		
		//Manager m4=new Manager("wei",11);
		//System.out.println(c.contains(m4));重写equals之前是false，重写equals方法之后比较的是内容
		
		System.out.println(c.contains(m3));
		
		
		}
}
 class Manager{
	String name;
	int age;
	Manager(String name,int age){
		this.name=name;
		this.age=age;
	}
	//重写equals方法
	//需求规定    如果名字和年龄都想同则表示同一个Manager
	public boolean equals(Object o){
		if(this==o) return true;
		if(o instanceof Manager){
		Manager mm=(Manager)o;
		if(mm.name==this.name&&mm.age==this.age ) return true;
		//if(mm.name.equals(this.name)&&mm.age==this.age) return true;
		}
		return false;
		
	}
}