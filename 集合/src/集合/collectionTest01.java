package 集合;
/*boolean add (object element) 向集合添加元素
 * int size() 获取元素个数
 * void clear() 清空集合
 * 
 * boolean isEmput()  判断集合是否为空
   Object [] toArray() 将集合转换为数组
   
   Iterator iterator () 获取集合中是否包含某个元素
   
    boolean contains(Object o);判断集合中是否包含某个元素
    boolean remove(Object o);删除集合中某个元素
 */
import java.util.*;
public class collectionTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 创建集合
		Collection c=new ArrayList();//多态 
		
		//2.添加元素
		c.add(1);//JDK5.0以后自动装箱
		c.add(new Integer(100));
		c.add(new Object());
		Customer cus=new Customer("wei",100);
		c.add(cus);
		
		//3.获取元素个数
	 System.out.println(c.size());
	System.out.println(c.isEmpty());
	//4.将集合转换成Object类型数组
	Object [] objs=c.toArray();
	for(int i=0;i<objs.length;i++){
		System.out.println(objs[i]);
	}
	 //5.清空
	 c.clear();
	 System.out.println(c.isEmpty());
	 
	 //迭代器
	 /*while方法
	 Iterator it=c.iterator();
	 while(it.hasNext()){
		 Object ob=it.next();
		 System.out.println(ob);
	 }*/
	 for(Iterator it=c.iterator();it.hasNext();){
		 Object ob=it.next();
		 System.out.println(ob);
	 }
	 /*boolean b=it.hasNext();判断是否有更多的元素，如果有返回true
	 Object o=it.next() ;将迭代器向下移动一位，并且取出指向的元素
	 原则：调用it.next()方法之前必须调用it.hasNext();*/
	}
}
 class Customer{
	 String name;
	 int age;
	Customer(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "Customer[name"+name+",age"+age+"]";
	}
}