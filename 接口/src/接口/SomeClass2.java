package �ӿ�;

public class SomeClass2 {
	OtherClass other;// ��Ա������ǳ����
	Integer myInt;// ��Ա�������ڰ�װ�࣬������
	int n;// �����������ͣ�������

//	SomeClass(String title, int n) {
//		other = new OtherClass(title);
//		myInt = new Integer(100);
//		this.n = n;
//		
//	}
	SomeClass2(SomeClass2 someClass){
		other=new OtherClass(someClass.other.toString());
		myInt=someClass.getInteger();
		n=someClass.getN();
	}
	
	SomeClass2(String title,int n){
		other = new OtherClass(title);
		myInt = new Integer(100);
		this.n = n;
	}

	void setTitle(String title) {
		other.setName(title);
	}

	void setN(int n) {
		this.n = n;
	}

	void setInteger(int n) {
		myInt = n;
	}
	
	int getN(){
		return n;
	}
	Integer getInteger(){
		return myInt; 
	}
	
	public String toString() {
		return "other:" + other + " n:" + n + " myInt:" + myInt;
	}
//
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	protected Object clone() throws CloneNotSupportedException {
		SomeClass2 someClass=new SomeClass2(this);
		return someClass;
	}
}
