package ����;

/*
 *  set���ϣ�HashSet
1.HashSet�ײ�ʵ������HashMap��HashMap�ײ�ʵ�ʲ����˹�ϣ�����ݽṹ��

2.��ϣ���ֽ�ɢ�б���ϣ��ײ���һ�����飬���������ÿ��Ԫ����һ����������
 ÿ������������һ����һ�޶���hashֵ������������±꣬��ĳ�����������еģ�ÿ���ڵ��ϵ�hashֵ������ȵģ�
 hashֵʵ������key����hashCode��������ͨ����hash function��ת���ɵ�ֵ
 
 3.������ϣ�������Ԫ��
   �ȵ��ñ��洢��key��hashCode����������ĳ���㷨�ó�hashֵ������������ϣ���в��������hashֵ����ֱ�Ӽ���Ԫ�ء����hashֵ�Ѿ�����
   ��������key��equals���������equals����false����Ԫ�ؼ��룬�������true���������
   
   4.HashSet��ʵ��HashMap�е�key���֣�HashSet��ʲô�ص㣬HashMap�е�keyӦ�þ�����ͬ���ص�
   
   5.HashMap��HashSet��ʼ����������16��Ĭ�ϼ���������0.75
   
   
   ���ۣ��洢��HashSet���ϻ���HashMap����key���ֵ�Ԫ�أ���Ҫͬʱ��дHashCode ��equals
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
		//��������
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
		
		//���Ԫ��
		s.add(e1);
		s.add(e2);
		s.add(e3);
		s.add(e4);
		s.add(e5);
		//�鿴Ԫ�ظ���
		System.out.println(s.size());
	}

}
class Employee{
	String no;//���
	String name;//����
	Employee(String no,String name){
		this.no=no;
		this.name=name;
	}
	//��дequals
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
	//��дhashCode
	public int hashCode(){
		return no.hashCode();//String�е�hashCode�����Ƿ��ش��ַ����Ĺ�ϣֵ������int
	}
	
}