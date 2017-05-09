package 集合;

/*
 *  set集合：HashSet
1.HashSet底层实际上是HashMap，HashMap底层实际采用了哈希表数据结构。

2.哈希表又叫散列表，哈希表底层是一个数组，这个数组中每个元素是一个单项链表，
 每个单向链表都有一个独一无二的hash值，代表数组的下标，在某个单向链表中的，每个节点上的hash值都是相等的，
 hash值实际上是key调用hashCode方法，在通过“hash function”转换成的值
 
 3.如何向哈希表中添加元素
   先调用被存储的key的hashCode方法，经过某个算法得出hash值，如果在这个哈希表中不存在这个hash值，则直接加入元素。如果hash值已经存在
   继续调用key的equals方法，如果equals返回false，则将元素加入，如果返回true，放弃添加
   
   4.HashSet其实是HashMap中的key部分，HashSet有什么特点，HashMap中的key应该具有相同的特点
   
   5.HashMap和HashSet初始化容量都是16，默认加载因子是0.75
   
   
   结论：存储在HashSet集合或者HashMap集合key部分的元素，需要同时重写HashCode 和equals
 */
import java.util.*;
public class SetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Set s=new HashSet();
		
		s.add(1);
		s.add(12);
		s.add(12);
		s.add(1);
		s.add(15);
		
		Iterator i=s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
			}
			*/
		//创建集合
		Set s=new HashSet();
		
		Employee e1=new Employee("1000","wei");
		Employee e2=new Employee("1000","wei");
		Employee e3=new Employee("2000","wei");
		Employee e4=new Employee("2001","hash");
		Employee e5=new Employee("3000","code");
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		System.out.println(e4.hashCode());
		
		//添加元素
		s.add(e1);
		s.add(e2);
		s.add(e3);
		s.add(e4);
		s.add(e5);
		//查看元素个数
		System.out.println(s.size());
	}

}
class Employee{
	String no;//编号
	String name;//姓名
	Employee(String no,String name){
		this.no=no;
		this.name=name;
	}
	//重写equals
	public boolean equals(Object o){
		if(this==o) return true;
		if(o instanceof Employee){
			Employee e=(Employee)o;
			if(e.no.equals(this.no)&&e.name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
	//重写hashCode
	public int hashCode(){
		return no.hashCode();//String中的hashCode方法是返回此字符串的哈希值，返回int
	}
	
}