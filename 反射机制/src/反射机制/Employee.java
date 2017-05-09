package 反射机制;

public class Employee {
	//Filed
	public String name;
	private int no;
	protected String add;
	boolean sex;
	
	//Constructor
	Employee (){System.out.println("Employee的无参数构造方法");}
	
	Employee (String name){this.name=name;}
	
	//Method
	public void get(){
		System.out.println("  132456");
	}
	//登录
	public boolean login(String name,String pwd){
		if("admin".equals(name)&&"123".equals(pwd)){
			return true;
			
		}
		return false;
	}
	//退出
	public void logout(){
		System.out.println("系统安全退出~！");
	}
}