package �ӿ�;

/*
 *ǳ���ƣ�ָ�ڸ���Դ�����У����ĳ����Ա������һ�����󣨳�String�Ͱ�װ�����֮�⣩
 *clone��������ֻ�Ǹ��������Ա��������ã����ڸ��ƺ�Ķ����У������еĳ�Ա����ֻ�Ƕ�ԭ����Ա���������
 *��û���������������Ա���ݣ��������л������ݳ�Ա�������ַ����Լ���װ���Ա��clone��������������
 *�������ڴ��ַ���������ǿ������ڴ���
 *����clone�����������ṩ�Գ�Ա���������ĸ���
 */
class SomeClass implements Cloneable {
	OtherClass other;// ��Ա������ǳ����
	Integer myInt;// ��Ա�������ڰ�װ�࣬������
	int n;// �����������ͣ�������

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
