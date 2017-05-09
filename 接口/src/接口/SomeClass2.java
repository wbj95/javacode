package 接口;

public class SomeClass2 {
	OtherClass other;// 成员对象，做浅复制
	Integer myInt;// 成员对象，属于包装类，做复制
	int n;// 基本数据类型，做复制

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
