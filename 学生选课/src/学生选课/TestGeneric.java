package ѧ��ѡ��;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	//���з���--Course����List��������
	public List<Course> courses;
	
	public TestGeneric()
	{
		this.courses=new ArrayList<Course>();
	}
	
	public void testAdd()
	{
		Course cr1=new Course("1","��ѧ����");
		courses.add(cr1);
		//courses.add("�ܶ������ֵĶ�����");
		Course cr2=new Course("2","��ѧӢ��");
		courses.add(cr2);
		
	}
	
	//��������
	public void testForEach()
	{
		for(Course cr:courses)
		{
			System.out.println("��������¿γ�:"+cr.getId()+","+cr.getName());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric ts=new TestGeneric();
		ts.testAdd();
		ts.testForEach();
	}

}
