package �������;

public class Employee {
	//Filed
	public String name;
	private int no;
	protected String add;
	boolean sex;
	
	//Constructor
	Employee (){System.out.println("Employee���޲������췽��");}
	
	Employee (String name){this.name=name;}
	
	//Method
	public void get(){
		System.out.println("  132456");
	}
	//��¼
	public boolean login(String name,String pwd){
		if("admin".equals(name)&&"123".equals(pwd)){
			return true;
			
		}
		return false;
	}
	//�˳�
	public void logout(){
		System.out.println("ϵͳ��ȫ�˳�~��");
	}
}