package ����;
/*boolean add (object element) �򼯺����Ԫ��
 * int size() ��ȡԪ�ظ���
 * void clear() ��ռ���
 * 
 * boolean isEmput()  �жϼ����Ƿ�Ϊ��
   Object [] toArray() ������ת��Ϊ����
   
   Iterator iterator () ��ȡ�������Ƿ����ĳ��Ԫ��
   
    boolean contains(Object o);�жϼ������Ƿ����ĳ��Ԫ��
    boolean remove(Object o);ɾ��������ĳ��Ԫ��
 */
import java.util.*;
public class collectionTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 ��������
		Collection c=new ArrayList();//��̬ 
		
		//2.���Ԫ��
		c.add(1);//JDK5.0�Ժ��Զ�װ��
		c.add(new Integer(100));
		c.add(new Object());
		Customer cus=new Customer("wei",100);
		c.add(cus);
		
		//3.��ȡԪ�ظ���
	 System.out.println(c.size());
	System.out.println(c.isEmpty());
	//4.������ת����Object��������
	Object [] objs=c.toArray();
	for(int i=0;i<objs.length;i++){
		System.out.println(objs[i]);
	}
	 //5.���
	 c.clear();
	 System.out.println(c.isEmpty());
	 
	 //������
	 /*while����
	 Iterator it=c.iterator();
	 while(it.hasNext()){
		 Object ob=it.next();
		 System.out.println(ob);
	 }*/
	 for(Iterator it=c.iterator();it.hasNext();){
		 Object ob=it.next();
		 System.out.println(ob);
	 }
	 /*boolean b=it.hasNext();�ж��Ƿ��и����Ԫ�أ�����з���true
	 Object o=it.next() ;�������������ƶ�һλ������ȡ��ָ���Ԫ��
	 ԭ�򣺵���it.next()����֮ǰ�������it.hasNext();*/
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