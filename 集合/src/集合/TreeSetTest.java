package ¼¯ºÏ;

import java.util.Iterator;
import java.util.TreeSet;


public class TreeSetTest {

	
	

	
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add(new Parent(3));
		set.add(new Child());
		set.add(new Parent(4));
		set.add(new Parent(4));
		System.out.println(set.size());
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
	}
}

 class Parent implements Comparable {
	private int age = 0;

	public Parent(int age) {
		this.age=age;
	}
	public int compareTo(Object o){
		System.out.println("Method of parent");
		Parent p = (Parent)o;
		return age>p.age?1:age<p.age?-1:0;
	}
	public String toString(){
		return "ÄêÁä"+age;
	}
}

 class Child extends Parent {

	public Child(){
		super(3);
	}
	public int compareTo(Object o) {

			// TODO Auto-generated method stub
			System.out.println("method of child");
//			Child o1 = (Child)o;
			return 1;

	}
}