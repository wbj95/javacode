package ѧ��ѡ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListTest listtest=new ListTest();
		listtest.add();
		listtest.testGet();
		listtest.testIterator();
	}

	public List cousesToSelect;
	public ListTest()
	{
		this.cousesToSelect=new ArrayList();
	}
	//��ӱ�ѡ�γ�
	public void add()
	{
		Course courses=new Course("1","���ݽṹ");
		cousesToSelect.add(courses);
		Course cou=(Course) cousesToSelect.get(0);
		System.out.println("��ӿγ̣�"+cou.getId()+","+cou.getName());
		
		Course cr1=new Course("2","C++");
		cousesToSelect.add(0, cr1);//��ԭ����0λ�õ����ݽṹ����1λ����
		Course cou2=(Course) cousesToSelect.get(0);
		System.out.println("����˿γ̣�"+cou2.getId()+","+cou2.getName());
		
		Course[] cr2={new Course("3","��ɢ��ѧ"),new Course("4","C#")};
		cousesToSelect.addAll(Arrays.asList(cr2));
		Course cou3=(Course) cousesToSelect.get(2);
		Course cou4=(Course) cousesToSelect.get(3);
		System.out.println("��������ſγ̣�"+cou3.getId()+","+cou3.getName()+";"+cou4.getId()+","+cou4.getName());
		
		Course[] cr3={new Course("4","�ߵ���ѧ"),new Course("5","��ѧӢ��")};
		cousesToSelect.addAll(2,Arrays.asList(cr3) );
		Course cou5=(Course) cousesToSelect.get(2);
		Course cou6=(Course) cousesToSelect.get(3);
		System.out.println("��������ſγ̣�"+cou5.getId()+","+cou5.getName()+";"+cou6.getId()+","+cou6.getName());
	}
	
	public void testGet()
	{
		for(int i=0;i<cousesToSelect.size();i++)
		{
			Course co=(Course) cousesToSelect.get(i);
			System.out.println("�����¿γ̣�"+co.getId()+","+co.getName());
		}
	}
	
	//��������������
	public void testIterator()
	{
		Iterator it=cousesToSelect.iterator();
		while(it.hasNext())
		{
			Course cs=(Course) it.next();
			System.out.println("�����¿γ̣�"+cs.getId()+","+cs.getName());
		}
	}
}
