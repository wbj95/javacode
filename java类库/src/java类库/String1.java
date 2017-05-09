package java类库;

public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str1="123456789123456125";
			int len=str1.length();//获取字符串的长度   int length()
			System.out.println(len);
			char ind=str1.charAt(5);//获取index下标的字符  char charAt(int index)
			System.out.println(ind);
			int ind2=str1.indexOf('5');//int indexOf(int ch)获取字符串中与ch字符相同的第一个下标，若无则返回-1
			System.out.println(ind2);
			int ind3=str1.indexOf('6', 6);
			//int indexOf(int ch,int fromIndex)
			//获取从fromIndex开始于ch字符相同的第一个下标，若无，返回-1
			System.out.println(ind3);
			int ind4=str1.indexOf("67");
			//int indexOf(String str)
			//获取字符串中与字符串str相同的第一个下标，若无，返回-1
			System.out.println(ind4);
			int ind5=str1.indexOf("123",6);
			//int indexOf(String str,int fromIndex)
			//获取字符串中从fromIndex与字符串str相同的第一个下标，若无，返回-1
			System.out.println(ind5);
			
			String str2="123456789";
			String str3=str2.concat("瘪陶是猪瘪");
			//String concat(String str)
			//在字符串尾增加str得到新的字符串
			System.out.println(str3);
			String str4=str3.replace('瘪', '屎');
			//String replace(char oldChar, char newChar)
			//将字符串中所有oldChar换成newChar得到一个新字符串
			System.out.println(str4);
			String str5=str4.replaceAll("123", "Zhu");
			//String raplaceAll(String regex,String raplacement)
			//将所有regex字符串换成raplacement得到一个新的字符串对象
			System.out.println(str5);
			String str6=str5.substring(2, 10);
			//String substring(int beginIndex,int endIndex)
			//截取从beginIndex位置开始到结束位置为endIndex的字符串得到一个新的对象，不包括endIndex位置的字符
			System.out.println(str6);
			String str7=str5.toLowerCase();
			//将字符串中所有字符转换成小写
			System.out.println(str7);
			String str8=str5.toUpperCase();
			//将字符串中所有字符转换成大写
			System.out.println(str8);
	}

}
