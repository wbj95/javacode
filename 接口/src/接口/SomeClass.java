package 接口;

/*
 *浅复制，指在复制源对象中，如果某个成员数据是一个对象（除String和包装类对象之外）
 *clone（）方法只是复制这个成员对象的引用，即在复制后的对象中，它所有的成员对象，只是对原来成员对象的引用
 *并没有真正复制这个成员数据，但是所有基本数据成员，包括字符串以及包装类成员，clone（）则真正复制
 *即分配内存地址，并将它们拷贝到内存中
 *覆盖clone（）方法，提供对成员对象真正的复制
 */
class SomeClass implements Cloneable {
	OtherClass other;// 成员对象，做浅复制
	Integer myInt;// 成员对象，属于包装类，做复制
	int n;// 基本数据类型，做复制

	SomeClass(String title, int n) {
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

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

class OtherClass {
	String name;

	OtherClass(String name) {
		this.name = name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
