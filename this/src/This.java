
public class This {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer m1=new Customer();
		m1.Setname("����");
		System.out.println(m1.name);//name���Ըĳ�Getname()
		Customer m2=new Customer("����");
	 System.out.println(m2.name);  
	}

}
class Customer{
	String name;
	Customer(){
		
	}
	Customer(String name){
		this.name=name;//this����ʡ�ԣ��������nameҪ��Ϊ_name
	}
	public void Setname(String name){
		this.name=name;
	}
	public String Getname(){
		return this.name;
	}
}//this�������ھ�̬����
//��̬�������޶�������this�޷�ʹ��