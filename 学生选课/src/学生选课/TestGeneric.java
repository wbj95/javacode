package 学生选课;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	//带有泛型--Course，的List类型属性
	public List<Course> courses;
	
	public TestGeneric()
	{
		this.courses=new ArrayList<Course>();
	}
	
	public void testAdd()
	{
		Course cr1=new Course("1","大学语文");
		courses.add(cr1);
		//courses.add("能都添加奇怪的东西？");
		Course cr2=new Course("2","大学英语");
		courses.add(cr2);
		
	}
	
	//遍历数组
	public void testForEach()
	{
		for(Course cr:courses)
		{
			System.out.println("添加了如下课程:"+cr.getId()+","+cr.getName());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric ts=new TestGeneric();
		ts.testAdd();
		ts.testForEach();
	}

}
