package Ñ§ÉúÑ¡¿Î;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String name;
	public Set course;
	
	public Student(String id,String name)
	{
		this.id=id;
		this.name=name;
		this.course=new HashSet();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
