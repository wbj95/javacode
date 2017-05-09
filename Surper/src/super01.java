
public class super01 {
/*
 * super构造  语法   super(实参) 作用： 通过子类调用父类 的构造方法 
 * 无参数构造方法  super()
 * 语规：构造方法第一行如果没有this(..),也没显示去调用
 * super(..)和this()只能放在构造方法的第一行
 * 所以super()和this()不能共存
 * super(..)调用父类的构造方法，但并不会创建父类型对象
 * 在java语言中，只要创建对象都会调用Object的无参数构造方法
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DebitAccount d=new DebitAccount();
Account A=new Account();
System.out.println(A.getactno());
d.getactno();
d.getbalace();
	}

}
class Account{//账户
	//属性
	private String actno;
	private double balace;
    //constructor
	Account(){
		//super();
		System.out.println("调用系统的无参数构造");
	}
	Account(String actno,double balace){
		this.actno=actno;
		this.balace=balace;
	}
	//setter and getter
	public void SetAcount(String actno){
        	this.actno=actno;
	}
	public String getactno(){
		return actno;
	}
	public void SetAccount(double balace){
   		this.balace=balace;
    }
     public double getbalace(){
     return balace;
    }
}
class DebitAccount extends Account{
	//信用卡
	private double debit;//信用度
	DebitAccount(){
	//super("1654",122);此处隐藏了super();
		super("1654",122);
		//super("1654",12);这个是第二行了，所以错误
	}
	DebitAccount(String actno,double balace,double debit){
		//通过子类调用父类的构造方法，作用是给当前子类中的父类型特征赋值
		super(actno,balace);
	}
public void Setter(double debit){
		this.debit=debit;
	}
	public double Getter(){
		return debit;
	}
}