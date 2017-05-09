package java类库;

public class StringBuffer1 {
	/*
	 * StringBuffer类创建可变长和可修改的字符串对象，也称为字符串缓冲区
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1=new StringBuffer();//字符串为0，容量为16
		int sb11=sb1.capacity();
		System.out.println(sb11);
		StringBuffer sb2=new StringBuffer(80);//字符串长度为0，容量为80
		StringBuffer sb3=new StringBuffer("abcd");//字符串为“abcd”，容量为20
		StringBuffer sb4=new StringBuffer("abcdeabcd");
		int sb5=sb4.length();//获取字符串长度
		System.out.println(sb5);//9
		int sb6=sb4.capacity();//获取字符串缓冲区的容量16+9
		System.out.println(sb6);//25
		char ch=sb4.charAt(3);//获取下标index位置的字符
		System.out.println(ch);//d
		int idx=sb4.indexOf("bc");//获取缓冲区中与字符串str相同的第一个下标，若无返回-1
		int idx1=sb4.indexOf("bc",5);//获取字符串中从位置fromIndex开始于字符串str相同的第一个下标，若无返回-1
		System.out.println(idx);//都类似于Sreing 类的方法 还有 substring
		
		//字符串缓冲区的修改

	}

}
