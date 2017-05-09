
public class This {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer m1=new Customer();
		m1.Setname("李四");
		System.out.println(m1.name);//name可以改成Getname()
		Customer m2=new Customer("张三");
	 System.out.println(m2.name);  
	}

}
class Customer{
	String name;
	Customer(){
		
	}
	Customer(String name){
		this.name=name;//this可以省略，但后面的name要改为_name
	}
	public void Setname(String name){
		this.name=name;
	}
	public String Getname(){
		return this.name;
	}
}//this不能用在静态变量
//静态方法中无对象，所以this无法使用