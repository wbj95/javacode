package 学生选课;

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
	//添加备选课程
	public void add()
	{
		Course courses=new Course("1","数据结构");
		cousesToSelect.add(courses);
		Course cou=(Course) cousesToSelect.get(0);
		System.out.println("添加课程："+cou.getId()+","+cou.getName());
		
		Course cr1=new Course("2","C++");
		cousesToSelect.add(0, cr1);//把原来在0位置的数据结构挤到1位置了
		Course cou2=(Course) cousesToSelect.get(0);
		System.out.println("添加了课程："+cou2.getId()+","+cou2.getName());
		
		Course[] cr2={new Course("3","离散数学"),new Course("4","C#")};
		cousesToSelect.addAll(Arrays.asList(cr2));
		Course cou3=(Course) cousesToSelect.get(2);
		Course cou4=(Course) cousesToSelect.get(3);
		System.out.println("添加了两门课程："+cou3.getId()+","+cou3.getName()+";"+cou4.getId()+","+cou4.getName());
		
		Course[] cr3={new Course("4","高等数学"),new Course("5","大学英语")};
		cousesToSelect.addAll(2,Arrays.asList(cr3) );
		Course cou5=(Course) cousesToSelect.get(2);
		Course cou6=(Course) cousesToSelect.get(3);
		System.out.println("添加了两门课程："+cou5.getId()+","+cou5.getName()+";"+cou6.getId()+","+cou6.getName());
	}
	
	public void testGet()
	{
		for(int i=0;i<cousesToSelect.size();i++)
		{
			Course co=(Course) cousesToSelect.get(i);
			System.out.println("有如下课程："+co.getId()+","+co.getName());
		}
	}
	
	//迭代器遍历数组
	public void testIterator()
	{
		Iterator it=cousesToSelect.iterator();
		while(it.hasNext())
		{
			Course cs=(Course) it.next();
			System.out.println("有如下课程："+cs.getId()+","+cs.getName());
		}
	}
}
