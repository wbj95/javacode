
public class super01 {
/*
 * super����  �﷨   super(ʵ��) ���ã� ͨ��������ø��� �Ĺ��췽�� 
 * �޲������췽��  super()
 * ��棺���췽����һ�����û��this(..),Ҳû��ʾȥ����
 * super(..)��this()ֻ�ܷ��ڹ��췽���ĵ�һ��
 * ����super()��this()���ܹ���
 * super(..)���ø���Ĺ��췽�����������ᴴ�������Ͷ���
 * ��java�����У�ֻҪ�������󶼻����Object���޲������췽��
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
class Account{//�˻�
	//����
	private String actno;
	private double balace;
    //constructor
	Account(){
		//super();
		System.out.println("����ϵͳ���޲�������");
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
	//���ÿ�
	private double debit;//���ö�
	DebitAccount(){
	//super("1654",122);�˴�������super();
		super("1654",122);
		//super("1654",12);����ǵڶ����ˣ����Դ���
	}
	DebitAccount(String actno,double balace,double debit){
		//ͨ��������ø���Ĺ��췽���������Ǹ���ǰ�����еĸ�����������ֵ
		super(actno,balace);
	}
public void Setter(double debit){
		this.debit=debit;
	}
	public double Getter(){
		return debit;
	}
}