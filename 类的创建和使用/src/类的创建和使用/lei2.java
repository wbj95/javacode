package ��Ĵ�����ʹ��;

public class lei2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Customer c=new Customer();
      c.setAge(120);
      System.out.println(c.getAge());
	}
	public static class Customer{
	private	int age;
	public  void setAge(int _age){
		if(_age<=0||_age>100)
		{
			System.out.println("��������䲻�Ϸ�");
			return;
		}
		age=_age;
	}
	public int getAge(){
		return age;
	}
		
	}

}
