package ����;
//   boolean contains(Object o);�жϼ������Ƿ����ĳ��Ԫ��
//   boolean remove(Object 0); ɾ��������ĳ��Ԫ��
//�洢�ڼ����е�Ԫ�ض�Ҫȥ��дequals����
import java.util.*;
public class CollectioinTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Collection c=new ArrayList();
		
		//����Integer���Ͷ���
		Integer m1=new Integer(10);
		c.add(m1);//��Ӷ���
		System.out.println(c.contains(m1));//true
		
		Integer m2=new Integer(10);
		System.err.println(c.contains(m2));//true
		//contains�����ײ���õ���equals���������equals����true�����ǰ���
		Manager m3=new Manager("wei",11);
		c.add(m3);
		
		//Manager m4=new Manager("wei",11);
		//System.out.println(c.contains(m4));��дequals֮ǰ��false����дequals����֮��Ƚϵ�������
		
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
	//��дequals����
	//����涨    ������ֺ����䶼��ͬ���ʾͬһ��Manager
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