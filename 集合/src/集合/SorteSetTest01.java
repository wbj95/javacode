package ����;
import java.util.*;
import java.text.*;
public class SorteSetTest01 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//��������
		SortedSet  sor=new TreeSet();
		
		//���Ԫ��
		sor.add(10);//�Զ�װ��
		sor.add(5);
		sor.add(105);
		sor.add(22);
		sor.add(55);
		//����
		Iterator i=sor.iterator();
		while(i.hasNext()){
			Object element=i.next();
			System.out.println(element);//ϵͳ�Ѿ���д��toString����
		}
		SortedSet str =new TreeSet();
		
		//���Ԫ��
		str.add("wei");
		str.add("chen");
		str.add("bie");
		str.add("Bie");
		str.add("bbb");
		i=str.iterator();
		while(i.hasNext()){
			Object element=i.next();
			System.out.println(element);//ϵͳ�Ѿ���д��toString����
		}
		SortedSet stime=new TreeSet();
		
		String st1="2008-08-08";
		String st2="2010-08-08";
		String st3="2012-05-02";
		String st4="2005-08-08";
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d1=s.parse(st1);
		Date d2=s.parse(st2);
		Date d3=s.parse(st3);
		Date d4=s.parse(st4);
		stime.add(d1);
		stime.add(d2);
		stime.add(d3);
		stime.add(d4);
		i=stime.iterator();
		while(i.hasNext()){
			Object element=i.next();
			if(element instanceof Date){
				Date dd=(Date)element;
			System.out.println(s.format(dd));
			}
			}
		
		
	}

}
