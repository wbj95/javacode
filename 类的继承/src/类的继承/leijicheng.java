package 类的继承;

public class leijicheng {
	public static void main(String[] args) {
     DetAccout st=new DetAccout();
     st.Setno("007");
     //st,Accout(001,55);无法调用构造方法
     st.Getno();//间接访问私有数据
     //System.out.println(st.ID);无法直接访问
	}	
}
/*
 * 信誉账户  ：子类  派生类  subclass
 * 子类可以把父类的数据都继承过来，包括私有数据
 * 但是子类无法直接访问私有数据，但是可以间接访问
 * 构造方法无法被继承
 */
class DetAccout extends Accout{
	double asd;
}
//账户类
//父类 超类 基类 superclass
class Accout{
	//账号
	private String ID;
	//余额
	double balance;
	//构造方法
	Accout(){}
	Accout(String Id,double balance){
		this.ID=ID;
		this.balance=balance;
	}
	public void Setno(String ID){
		this.ID=ID;
	}
	public void Getno(){
		System.out.println(ID);
	}
	/*
	 * public String Getno(){
	 *   return ID
	 * }
	 */
}